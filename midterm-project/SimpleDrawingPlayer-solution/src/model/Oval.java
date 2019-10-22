package model;

import sound.MidiSynth;

import java.awt.*;

public class Oval extends Shape {
    private static Color PLAYING_COLOR = new Color(15, 17, 50);

    public Oval(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
    }

    @Override
    public void drawGraphics(Graphics g) {
        g.drawOval(x, y, width, height);
    }

    @Override
    public void fillGraphics(Graphics g) {
        g.fillOval(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        Color save = g.getColor();
        if (selected) {
            g.setColor(PLAYING_COLOR);
        } else {
            g.setColor(Color.lightGray);
        }
        fillGraphics(g);
        g.setColor(save);
        drawGraphics(g);

        if (playLineCoord > 0 && playLineCoord < width) {
            g.setColor(Color.pink);
            g.drawLine(x + playLineCoord, y, x + playLineCoord, y + height);
            g.setColor(save);
        }
    }
}
