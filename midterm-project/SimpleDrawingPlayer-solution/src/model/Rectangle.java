package model;

import sound.MidiSynth;

import java.awt.*;

public class Rectangle extends Shape {
    private static Color PLAYING_COLOR = new Color(230, 158, 60);

    public Rectangle(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
    }

    @Override
    public void drawGraphics(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    @Override
    public void fillGraphics(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        Color save = g.getColor();
        if (selected) {
            g.setColor(PLAYING_COLOR);
        } else {
            g.setColor(Color.white);
        }
        fillGraphics(g);
        g.setColor(save);
        drawGraphics(g);

        if (playLineCoord > 0 && playLineCoord < width) {
            g.setColor(Color.red);
            g.drawLine(x + playLineCoord, y, x + playLineCoord, y + height);
            g.setColor(save);
        }
    }
}
