package com.company;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

 //отображает  фракталы

class JImageDisplay extends JComponent
{
    /** Управляет изображением, содержимое которого мы можем записывать.*/
    private BufferedImage displayImage;

    /**  принимает целочисленные
     значения ширины и высоты, и инициализирует объект BufferedImage новым
     изображением с этой шириной и высотой, и типом изображения
     TYPE_INT_RGB. */

    public JImageDisplay(int width, int height) {
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);

    }
    /** нужно всегда
     вызывать метод суперкласса paintComponent (g) так, чтобы объекты             берем реализ метода из баз класса и мож  дополнить
     отображались правильно. Затем изображение втягивается в компонент. */

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(displayImage, 0, 0, displayImage.getWidth(), displayImage.getHeight(), null);
    }
    /**Устанавливает все пиксели в данных изображения черными.*/
    public void clearImage()
    {
        int[] blankArray = new int[getWidth() * getHeight()];
        displayImage.setRGB(0, 0, getWidth(), getHeight(), blankArray, 0, 1);
    }
    /**Устанавливает пиксель определенного цвета.*/
    public void drawPixel(int x, int y, int rgbColor)
    {
        displayImage.setRGB(x, y, rgbColor);
    }
}
