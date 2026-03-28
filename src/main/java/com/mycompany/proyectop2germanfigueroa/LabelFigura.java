package com.mycompany.proyectop2germanfigueroa;


import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelFigura extends JLabel {

    private final Figura figura;
    private final Ventana ventana;
    private Point pressedClick;

    public LabelFigura(Figura figura, Ventana ventana) {
	this.figura = figura;
	this.ventana = ventana;
	setIcon(obtenerImagen(figura.getTipo()));
	setText(figura.getTexto());
	setFont(new Font(figura.getFuente(), figura.getEstiloLetra(), figura.getTamanoLetra()));
	setHorizontalTextPosition(JLabel.CENTER);
	setVerticalTextPosition(JLabel.CENTER);

	setComponentPopupMenu(ventana.getPopupMenu());
	setBounds(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
	setBackground(Color.decode(figura.getColorFondo()));
	setOpaque(true);

	this.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		pressedClick = e.getPoint();

		if (e.isMetaDown()) {
		    ventana.getPopupMenu().show(e.getComponent(), e.getX(), e.getY());
		}
	    }
	});

	this.addMouseMotionListener(new MouseMotionAdapter() {
	    @Override
	    public void mouseDragged(MouseEvent e) {
		if (pressedClick != null) {
		    int x = getX() + e.getX() - pressedClick.x;
		    int y = getY() + e.getY() - pressedClick.y;

		    setLocation(x, y);

		    figura.setX(x);
		    figura.setY(y);
		}
	    }
	});
    }

    private ImageIcon obtenerImagen(TipoFigura tipo) {
	ImageIcon icono = null;

	switch (tipo) {
	    case TipoFigura.INICIO -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/014.png"));
	    }
	    case TipoFigura.FIN -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/011.png"));
	    }
	    case TipoFigura.PROCESO -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/013.png"));
	    }
	    case TipoFigura.DECISION -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/011.png"));
	    }
	    case TipoFigura.BUCLE_FOR -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/009.png"));
	    }
	    case TipoFigura.BUCLE_WHILE -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/010.png"));
	    }
	    case TipoFigura.IMPRESION_PANTALLA -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/012.png"));
	    }
	    case TipoFigura.CONECTOR_HORIZONTAL -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/007.png"));
	    }
	    case TipoFigura.CONECTOR_VERTICAL -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/008.png"));
	    }
	    default -> {
		icono = new ImageIcon(getClass().getResource("/imagenes/013.png"));
	    }
	}
	return icono;
    }

    public Figura getFigura() {
	return figura;
    }

    public void actualizarTexto(String texto) {
	figura.setTexto(texto);
	setText(texto);
    }

    public void actualizarColorFondo(String color) {
	figura.setColorFondo(color);
	setBackground(Color.decode(color));
    }

    public void actualizarFuente() {
	Font fuente = new Font(figura.getFuente(), figura.getEstiloLetra(), figura.getTamanoLetra());
	setFont(fuente);
	repaint();
    }

}
