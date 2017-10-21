if ! [ -x "$(command -v brew)" ]; then
  echo 'Install Homebrew' >&2
  /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
  brew update
fi

if ! [ -x "$(command -v pip)" ]; then
  echo 'Install python' >&2
  brew install python
  echo 'Install pip, Please insert password' >&2
  sudo easy_install pip
fi

if ! [ -x "$(command -v pio)" ]; then
  echo 'Install Platformio' >&2
  brew install platformio
fi

# lsof -i tcp:3000 -t
# kill -9 $(lsof -i tcp:3000 -t)