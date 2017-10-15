# -*- coding: utf-8 -*-

"""
  autorun.py
  Habiteeth
  
  Created by Hyeon soo Ha on 2017. 10. 15..
  Copyright © 2017년 MIRO. All rights reserved.

  NOTE: Autorun script
"""

import subprocess as process
import re as regex
import time
import sys

class HabiteethAutoBuilder:
    _output_log = {
        "init": """
        autorun.py
        Habiteeth
  
        Created by Hyeon soo Ha on 2017. 10. 15..
        Copyright © 2017년 MIRO. All rights reserved.

         NOTE: Autorun script
        """,
        "list": [
            "[0]: build source code",
            "[1]: upload source code",
            "[2]: unit test",
            "[z]: Exit"
        ]
    }

    envirment_llst = []

    def __init__(self):
        print(self._output_log["init"])
        self._load_envirment_list()
        self._menu(self._output_log["list"])

    def _load_envirment_list(self):
        readFile = open("platformio.ini", "r")
        regexOutputArray = regex.findall(r"\[env\:+[a-z]+\_+[a-z0-9]+\]", readFile.read())
        self._envirment_llst = list(map(lambda env: env[len("[env:"): len(env) - 1], regexOutputArray))
        readFile.close()

    def _menu(self, list):
        # print out menu list
        print("[\033[1;36;40mMIRO\033[0m platformio auto build system]")
        for index in list:
            print(index)

        #validation check
        while(1):
            key_number = raw_input("\033[1;33;40minsert key:\033[0m")
           
            if key_number.isdigit() and int(key_number) < len(list) - 1:
                # run target
                self._open_function(key_number)()
                self._menu(list)
                break
            elif key_number.upper() == "Z":
                # exit
                print("exit")
                break
            else:
                # error
                print("\033[1;31;40m잘못된 값을 입력하셨습니다.\033[0m")

    def _open_function(self, key_value):
        return {
            '0': self._build,
            '1': self._upload,
            '2': self._unit_test
        }[key_value]

    
    def _build(self):
        is_auto_build = str(raw_input("\n\033[1;33;40m자동 빌드 하시겠습니까? y/n\033[0m")).upper()
        if is_auto_build == "N":
            print("\033[1;33;40m빌드 타겟을 선택해주세요\033[0m")
            for index in range(len(self._envirment_llst)):
                print("[" + str(index) + "]:" + str(self._envirment_llst[index]))

            print("[z]: cancel")

            while(1):
                key_number = raw_input("\033[1;33;40minsert key:\033[0m")
           
                if key_number.isdigit() and int(key_number) < len(self._envirment_llst) - 1:
                    # run target
                    target_envirment = self._envirment_llst[int(key_number)]
                    process.call(["pio", "run", "-e", target_envirment])
                    break
                elif key_number.upper() == "Z":
                    # cancel
                    break
                else:
                    # error
                    print("\033[1;31;40m잘못된 값을 입력하셨습니다.\033[0m")
            
        else:
            pass
            process.call(["pio", "run"])
        
        print("\n\n\n")
    
    def _upload(self):
        sel = str(raw_input("\033[1;33;40mplatformio.init default로 업로드 하시겠습니까? (y/n): \033[0m")).upper()

        if sel == "N":
            print("\n PORT를 선택해주세요")
            time.sleep(1)
            process.call(["pio", "device", "list"])

            target_port = str(raw_input("\033[1;33;40m디바이스와 연결된 PORT 이름을 입력해주세요:\033[0m"))
        
            for index in range(len(self._envirment_llst)):
                print("[" + str(index) + "]:" + str(self._envirment_llst[index]))

            envir = str(raw_input("\033[1;33;40m빌드 타겟을 선택해주세요:\033[0m"))

            if envir.isdigit() and int(envir) < len(self._envirment_llst):
                # run target
                target_envirment = self._envirment_llst[int(envir)]
                process.call(["pio", "run", "-e", target_envirment, "-t", "upload", "--upload-port", target_port])
            else:
                # error
                print("\033[1;31;40m잘못된 값을 입력하셨습니다.\033[0m")
        else:
            any_port = "/dev/ttyUSB*"
            if sys.platform.startswith('win'):
                any_port = "COM*"
            process.call(["pio", "run", "-t", "upload", "--upload-port", any_port])
        print("\n\n\n")

    def _unit_test(self): 
        sel = str(raw_input("\033[1;33;40mDevice 유닛테스트/ Native 유닛테스트 (d/n): \033[0m")).upper()

        if sel == "D":
            process.call(["pio", "test", "-e", "device_test", "-i", "native_test"])
        elif sel == "N":
            process.call(["pio", "test", "-e", "native_test", "-i", "device_test"])
        else:
            print("\033[1;31;40m잘못된 값을 입력하셨습니다.\033[0m")
        
        print("\n\n\n") 

if __name__ == "__main__" :
    app = HabiteethAutoBuilder()
