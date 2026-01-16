#include <iostream>
using namespace std;

void conditionalTest(int x)
{
    if (x == 0)
    {
        cout << "That was nothing";
    }

    else if (x >= 1 && x < 100)
    {
        cout << "That was something";
    }

    else if (x < 0)
    {
        cout << "Hey man, don't do that. Stay positive";
    }

    else
    {
        cout << "Whoa, that's a lot";
    }
}

int main()
{
    int x;
    cout << "Hello World! \n";
    cout << "Enter a number please:";
    cin >> x;
    cout << "\nYour number was " << x << "\n";
    conditionalTest(x);

    return 0;
}
