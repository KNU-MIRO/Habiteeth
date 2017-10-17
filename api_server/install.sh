if ! [ -x "$(command -v brew)" ]; then
  echo 'Install Homebrew' >&2
  /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
  brew update
fi

if ! [ -x "$(command -v javac)" ]; then 
  echo 'Install Java' >&2
  brew cask install java
fi

if ! [ -x "$(command -v vertx)" ]; then
  echo 'Install Vert.x 3.0' >&2
  brew install vert.x
fi

# lsof -i tcp:3000 -t
# kill -9 $(lsof -i tcp:3000 -t)