#include <iostream>
#include <cmath>

double series_value(double x);

int main()
{
    using std::cout;
    using std::cin;
    setlocale(LC_ALL, "Rus");
    cout << "Введите значение х( -0.55 < x < 2.44, пример: 1.0): ";
    double x;
    cin >> x;
    while (x <= -0.55 || x >= 2.44)//ограничение на сходимость ряда
    {
        cout << "Некорректное значение. Попробуйте снова.\n"
            << "Введите значение х( -0.55 < x < 2.44, пример: 1.0): ";
        cin >> x;
    }
    cout << "Значение ряда при x = " << x << " : " << series_value(x)<<std::endl;
    return 0;
}

double series_value(double x) {
    double value = 0;
    double curr = 0;
    double prev = 1;
    int n = 1;
    while (fabs(prev - curr) > 10e-5) {
        prev = curr;
        curr = sqrt(n) * pow((x - 1.0), 3 * n - 2) / pow(3, n);
        value += curr;
        n++;
    }
    return value;
}