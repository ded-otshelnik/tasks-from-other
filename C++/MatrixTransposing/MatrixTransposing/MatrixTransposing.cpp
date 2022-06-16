#include <iostream>
#include <cmath>
using namespace std;

void show(double** matrix, int n, int m);
double** matrix_transpose(double** matrix, int n, int m);

int main()
{
    srand((unsigned)time(0));
    setlocale(LC_ALL, "Rus");
    int n = rand() % 6 + 1;
    double** matrix = new double*[n];
    int m = rand() % 6 + 1;
    for (int i = 0; i < n; i++) {
        matrix[i] = new double[m];
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            matrix[i][j]= rand() % 6 + 1;
        }
    }
    cout << "Исходная матрица:"<<endl;
    show(matrix, n, m);
    double** matrix_t = matrix_transpose(matrix, n, m);
    cout << "Транспонированная матрица:" << endl;
    show(matrix_t, m, n);
}

double** matrix_transpose(double** matrix,int n,int m) {
    double** result = new double* [m];
    for (int i = 0; i < m; i++) {
        result[i] = new double[n];
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            result[i][j] = matrix[j][i];
        }
    }
    return result;
}
void show(double** matrix, int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << matrix[i][j]<<" ";
        }
        cout << endl;
    }
}