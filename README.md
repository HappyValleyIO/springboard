# Springboard

![Java CI with Gradle](https://github.com/HappyValleyIO/springboard/workflows/Java%20CI%20with%20Gradle/badge.svg)

This is a starter template for building monolithic Spring based applications using modern web tooling.

## Getting started

Tests will spin up their own independent containers using test containers.

## Developing

I recommend installing the [Pebble Intellij plugin](https://github.com/bjansen/pebble-intellij). Note there are post-installation instructions on the github page for the plugin.

You can type `var` and hit Crtl + Space to have it autocomplete a type hint at the top of the file, like:

```pebble
{# @pebvariable name="email" type="java.lang.String" #}
```

This lets the plugin know that any reference to email should use the intellij autocomplete for strings.

Another step toward great dev flow is to mark the base language of pebble files as HTML. You can do this by:

* Opening Settings Ctrl + Alt + S
* Navigating to `Languages & Frameworks`
* Opening `Template Data Languages`
* Adding the `src/main/resources/templates` directory and marking the base language as HTML

### Live Reload

Spring DevTools comes with LiveReload out of the box. http://livereload.com/

While running in the `dev` profile, a line of javascript is added to each page that will open a websocket to the server so that it can refresh the page on updates.

## Emails

For more email template look at https://htmlemail.io/

# Docs

We use [mkdocs](https://www.mkdocs.org/) to build this documentation.

## Install dependencies

You'll need python, pip and mkdocs installed to work on these docs. 

I would use the [pyenv-installer](https://github.com/pyenv/pyenv-installer) to install py-env. Then install a recent version of python:

```
pyenv install 3.8.2
pyenv global 3.8.2
```

Followed by an appropriate version of pip by following the instructions [here](https://pip.pypa.io/en/stable/installing/).

Then install the dependencies by running `pip install -r requirements.txt` in the `docs` folder.

## Developing

To run the docs in dev mode, run the command `mkdocs serve`.