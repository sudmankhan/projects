#include <iostream>
using namespace std;

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
    
    int** board_matrix() {
        int matrix[height-1][width-1];
        return arr[][];
    }

    void render()
    {
        cout << "Height: " << this->height << endl;
        cout << "Width: " << this->width << endl;
        int matrix[][] = this->board_matrix();
    }
};

int main(int argc, char const *argv[])
{
    Game game(10, 20);
    game.render();
    return 0;
}
