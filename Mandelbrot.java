package com.company;

import java.awt.geom.Rectangle2D;

//  для вычисления фрактала Мандельброта

public class Mandelbrot extends FractalGenerator
{

       /**
     метод позволяет генератору
     фракталов определить наиболее «интересную» область комплексной плоскости
     для конкретного фрактала.
     передается прямоугольный объект и надо изменить поля
     прямоугольника для отображения правильного начального диапазона для
     фрактала.
     */
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    /**Этот метод реализует итерационную функцию для фрактала Мандельброта.
     Требуется два дабла для действительной и мнимой частей комплекса.
     Вычисляется количество итераций для соответствующей координаты.
     */

    public static final int MAX_ITERATIONS = 2000;
    public int numIterations(double x, double y)
    {
        int iteration = 0;
        double zreal = 0;
        double zimaginary = 0;

        /**Вычислить Zn = Zn-1 ^ 2 + c, где значения представляют собой комплексные числа,
         *  представленные по zreal и zimaginary, Z0 = 0, а c - особая точка в
         фрактале, который мы отображаем (заданный x и y). Это повторяется
         до Z ^ 2> 4 (абсолютное значение Z больше 2) или максимум
         достигнуто количество итераций.
         */
        while (iteration < MAX_ITERATIONS &&
                zreal * zreal + zimaginary * zimaginary < 4)
        {
            double zrealUpdated = zreal * zreal - zimaginary * zimaginary + x;
            double zimaginaryUpdated = 2 * zreal * zimaginary + y;
            zreal = zrealUpdated;
            zimaginary = zimaginaryUpdated;
            iteration += 1;
        }
        if (iteration == MAX_ITERATIONS)
        {
            return -1;  //чтобы показать, что точка не выходит за границы
        }
        return iteration;
    }

}