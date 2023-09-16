#include <iostream>
using namespace std;
// #include <conio.h>
#include <stdlib.h>

class Snake
{
};

class Apple
{
};

class Game
{
public:
    int height;
    int width;

    Game(int h, int w)
    {
        this->height = h;
        this->width = w;
    }
    
    char** board_matrix(int height, int width) {
        char** arr = new char*[height-1];
        for (int i = 0; i < height; i++)
        {
            arr[i] = new char[width];
            for (int j = 0; j < width; j++)
            {
                arr[i][j] = 'a';
            }
        }
        return arr;
    }

    void render()
    {
        cout << "Height: " << this->height << endl;
        cout << "Width: " << this->width << endl;
        char** matrix = board_matrix(height, width);
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                cout << matrix[i][j];
            }
            cout << endl;
        }
        
    }
};

int main(int argc, char const *argv[])
{
    Game game(10, 20);
    game.render();
    return 0;
}
