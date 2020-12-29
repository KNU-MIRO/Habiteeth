# Habiteeth IoT Platform

MIRO Internet of things team, Habiteeth IoT Platform.

  - Hyeonsu Ha (project manager, iOS developer)
  - Dongho Choi (Embedded system developer)
  - Dongyoung Kim (Back-end developer)

# New Features!

  - Created New Repository
  - Create AVR Build System as PlatformIO
  - Restful API Server base on Vert.X


You can also:
  - TDD as Unity platfrom on platformIO
  - try run autorun.py for build/upload your code on AVR device

### Tech

Habiteeth uses a number of open source projects to work properly:

* [PlatformIO] - fast AVR build system (better then arduinio IDE)
* [RxSwift] - Reative mobile application
* [Ruby-on-rails] - fast ruby network application framework

And of course Habiteeth itself is open source on GitHub.

### Installation & Development
>##### IoT AVR Device Setup
Habiteeth requires platformIO and python 2.7.x or 3.x to run. http://platformio.org
```sh
$ easy_install pip
$ pip install -U platformio
$ pio --help
```
easy run
```sh
$ python autorun.py
```
build
```sh
$ pio run -e "ENVIROMENT"
```
upload
```sh
$ pio run -e "ENVIRMENT" -t upload --upload-port "COM*" or "/dev/ttyUSB*"
```

>##### iOS Application
Habiteeth requires Xcode IDE and OS X envirment to run.
```sh
$ pod install
$ open Habiteeth.xcworkspace
```
>##### Server
Habiteeth requires rails to run.
```sh
$ brew bundle
$ rbenv install
$ gem install
$ rails --version
```

local run
```sh
bin/rails server
```

>##### Using Restful API Server base on Vert.X
api_server/install.sh

```sh
$ sh ./install.sh
```
현수형 안녕하세용~ㅎㅎㅎ
