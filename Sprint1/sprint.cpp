#include <iostream>
#include <vector>
#include <string>
#include <optional>
#include <SFML/Graphics.hpp>

using namespace std;

class ImageViewer
{
private:
    std::vector<sf::Texture> images;
    std::optional<sf::Sprite> sprite;
    int currentIndex = 0;

public:
    void loadImages();
    void setImage(int index);
    void draw(sf::RenderWindow &window);
};

void ImageViewer::loadImages()
{
    std::vector<std::string> filenames =
        {
            "images/smug.jpg",
            "images/fred.gif",
            "images/gulp.gif",
            "images/larry.png",
            "images/shrek.png",
            "images/calc.jpg",
            "images/chimkin.png",
            "images/rock.png",
            "images/sonic-freaky.png",
            "images/james.png"};

    for (const auto &name : filenames)
    {
        sf::Texture texture;
        if (texture.loadFromFile(name))
        {
            images.push_back(texture);
        }
        else
        {
            std::cout << "Failed to load: " << name << "\n";
        }
    }

    if (!images.empty())
    {
        currentIndex = 0;
        sprite.emplace(images[0]);
    }
}

void ImageViewer::setImage(int index)
{
    if (index >= 0 && index < (int)images.size())
    {
        currentIndex = index;

        if (!sprite)
            sprite.emplace(images[currentIndex]);
        else
            sprite->setTexture(images[currentIndex], true);
    }
}

void ImageViewer::draw(sf::RenderWindow &window)
{
    if (sprite)
        window.draw(*sprite);
}

int main()
{
    int x;
    cout << "Hello World! \n";
    cout << "Enter a number please:";
    cin >> x;
    while (x < 1 || x > 10)
    {
        cout << "Invalid, enter a number between 1-10. Sorry, could've said this sooner: ";
        cin >> x;
    }

    sf::RenderWindow window(sf::VideoMode(sf::Vector2u(900, 700)), "Select Image with number keys (0-9)");
    ImageViewer viewer;
    viewer.loadImages();

    if (x >= 1 && x <= 10)
    {
        viewer.setImage(x - 1);
    }

    while (window.isOpen())
    {
        while (const auto event = window.pollEvent())
        {
            if (event->is<sf::Event::Closed>())
            {
                window.close();
            }

            else if (const auto *keyPressed = event->getIf<sf::Event::KeyPressed>())
            {
                if (keyPressed->scancode == sf::Keyboard::Scancode::Escape)
                    window.close();
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num1)
                    viewer.setImage(0);
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num2)
                    viewer.setImage(1);
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num3)
                    viewer.setImage(2);
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num4)
                    viewer.setImage(3);
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num5)
                    viewer.setImage(4);
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num6)
                    viewer.setImage(5);
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num7)
                    viewer.setImage(6);
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num8)
                    viewer.setImage(7);
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num9)
                    viewer.setImage(8);
                else if (keyPressed->scancode == sf::Keyboard::Scancode::Num0)
                    viewer.setImage(9);
            }
        }

        window.clear();
        viewer.draw(window);
        window.display();
    }

    return 0;
}
