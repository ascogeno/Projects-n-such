# Lightly Funny Image Viewer

A simple program, if pointless. It will prompt the user for a number, ask for a different number if the one given is too large, and show an image corresponding to that number.
Once viewing an image, the number keys can be used to look at any of the 10 included images. Included for convenience.

## Instructions for Build and Use

Steps to build and/or run the software:

1. Download the contents of the LightlyFunnyImageViewer folder.
2. Locate "sprint.exe" file.
3. Run the file.
4. (As needed) Click "Allow" if and when windows attempts to stop you from running the executable.

Instructions for using the software:

1. In the console, enter a number once prompted. If you wish to test the conditional at play, enter a number higher than 10.
2. Once a valid number has been entered, a corresponding image will be shown in a seperate window. Click on this window.
3. Once the window is selected, the number pad can be used to sort through the 10 included images.

## Development Environment

To recreate the development environment, you need the following software and/or libraries with the specified versions:

- Visual Studio Code/Visual Studio Commmunity
- Modify Visual Studio installation with C++ tools
- SFML Library

## Useful Websites to Learn More

I found these websites useful in developing this software:

- [W3Schools](https://www.w3schools.com/cpp/)
- [ChatGPT](https://chatgpt.com/)
- [Stack Overflow](https://stackoverflow.com/questions/42679720/c-cannot-open-source-file)

## Future Work

The following items I plan to fix, improve, and/or add to this project in the future:

- [ ] If the user enters text rather than a number, the code for a number too large executes over and over in an endless loop. The only fix without fixiing the code is to close the console/window
- [ ] I'd rather have a GUI the user interacts with than the current console/window hybrid
- [ ] I want to have the images scale to be the same size, but I couldn't get that working in this iteration
- [ ] I want to figure out how to properly work with C++, the SFML library barely worked and only compiled in the terminal. VS Code still hates the include line at the top of the file
