#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>
#include <windows.h>
using namespace std;

int main()
{
    srand((unsigned)time(0));
    setlocale(LC_ALL, "Rus");
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    ifstream in;
    in.open("f1.txt");
    string buff = "";
    vector<string> text;
    while (!in.eof()) {
        in >> buff;
        switch (rand() % 2)
        {
            case 0: {
                text.push_back(buff+"\n");
                break;
            }
            case 1: {
                reverse(text.begin(), text.end());
                text.push_back(buff+"\n");
                reverse(text.begin(), text.end());
                break;
            }
        }
    }
    in.close();
    ofstream out;
    out.open("f2.txt",ios_base::trunc||ios_base::out);
    for (auto iterator = text.begin(); iterator != text.end(); iterator++) {
        out << *iterator;
    }
    cout << "Обработка завершена.\n\n";
    out.close();
    system("pause");
}