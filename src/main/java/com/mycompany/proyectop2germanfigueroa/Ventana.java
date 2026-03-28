package com.mycompany.proyectop2germanfigueroa;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Ventana extends javax.swing.JFrame {
  
    private ArrayList<Figura> figuras;
    private ArrayList<LabelFigura> labelFiguras;
    private ArrayList<Clase> clases;

    private final String[] coloresPredeterminados = {"#007BFF", "#28A745", "#FD7E14", "#6F42C1", "#DC3545"};
    private boolean modoDiagrama;
    private boolean esEditorDeDiagrama;

    private final int ANCHO_FIGURA = 138;
    private final int ALTO_FIGURA = 70;

    private LabelFigura figuraSeleccionada;
    private Figura figuraCopiada;

    public Ventana() {
	initComponents();
	figuras = new ArrayList<>();
	labelFiguras = new ArrayList<>();
	clases = new ArrayList<>();
	modoDiagrama = true;
	esEditorDeDiagrama = true;
	figuraSeleccionada = null;
	DefaultListModel listModelVariables = new DefaultListModel();
	lista_variables.setModel(listModelVariables);

	DefaultListModel listModelOperaciones = new DefaultListModel();
	lista_operaciones.setModel(listModelOperaciones);

	DefaultTreeModel treeModel = new DefaultTreeModel(new DefaultMutableTreeNode("Clases", true));
	jt_classes.setModel(treeModel);
    }
    public static void main(String[]args){
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }

    private LabelFigura agregarFiguraPanel(Figura figura) {
	LabelFigura label = new LabelFigura(figura, this);
	labelFiguras.add(label);
	label.actualizarFuente();
	panel_diagramaDrag.add(label);
	panel_diagramaDrag.revalidate();
	panel_diagramaDrag.repaint();

	return label;
    }

    public void setFiguraSeleccionada(LabelFigura label) {
	this.figuraSeleccionada = label;

	if (figuraSeleccionada != null) {
	    Figura figura = figuraSeleccionada.getFigura();
	    spinner_tamano.setValue(figura.getTamanoLetra());
	    jcb_estiloLetra.setSelectedIndex(figura.getEstiloLetra());
	    btnColorFondo.setBackground(Color.decode(figura.getColorFondo()));
	}
    }

    public JPopupMenu getPopupMenu() {
	return figura_jpm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlg_propiedades = new javax.swing.JDialog();
        panel_propiedades = new javax.swing.JPanel();
        lbl_textoProp = new javax.swing.JLabel();
        lbl_colorProp = new javax.swing.JLabel();
        lbl_fuenteProp = new javax.swing.JLabel();
        lbl_textoFigura = new javax.swing.JLabel();
        lbl_altoProp = new javax.swing.JLabel();
        lbl_sizeLetraProp = new javax.swing.JLabel();
        lbl_anchoProp = new javax.swing.JLabel();
        lbl_colorFigura = new javax.swing.JLabel();
        lbl_fuenteFigura = new javax.swing.JLabel();
        lbl_sizeLetraFigura = new javax.swing.JLabel();
        lbl_anchoFigura = new javax.swing.JLabel();
        lbl_altoFigura = new javax.swing.JLabel();
        dlg_variables = new javax.swing.JDialog();
        panel_creacionVariables = new javax.swing.JPanel();
        lbl_nombreVariable = new javax.swing.JLabel();
        txt_nombreVariable = new javax.swing.JTextField();
        lbl_tipoVariable = new javax.swing.JLabel();
        jcb_tipoVariable = new javax.swing.JComboBox<>();
        btn_confirmarVariable = new javax.swing.JButton();
        btn_cancelarVariable = new javax.swing.JButton();
        lbl_alcanceVariable = new javax.swing.JLabel();
        jcb_alcanceVariable = new javax.swing.JComboBox<>();
        lbl_titulo_crearVariable = new javax.swing.JLabel();
        dlg_operaciones = new javax.swing.JDialog();
        panel_creacionOperaciones = new javax.swing.JPanel();
        lbl_operador = new javax.swing.JLabel();
        lbl_var1 = new javax.swing.JLabel();
        btn_confirmarOperacion = new javax.swing.JButton();
        btn_cancelarOperacion = new javax.swing.JButton();
        lbl_var2 = new javax.swing.JLabel();
        lbl_titulo_crearOperacion = new javax.swing.JLabel();
        lbl_resultado = new javax.swing.JLabel();
        jcb_operador = new javax.swing.JComboBox<>();
        jcb_var2 = new javax.swing.JComboBox<>();
        jcb_var1 = new javax.swing.JComboBox<>();
        jcb_resultado = new javax.swing.JComboBox<>();
        figura_jpm = new javax.swing.JPopupMenu();
        jmItem_cambiarColor = new javax.swing.JMenuItem();
        jmItem_cambiarTexto = new javax.swing.JMenuItem();
        jmItem_cambiarFuente = new javax.swing.JMenuItem();
        sep1 = new javax.swing.JPopupMenu.Separator();
        jmItem_copiar = new javax.swing.JMenuItem();
        jmItem_eliminar = new javax.swing.JMenuItem();
        jmItem_propiedades = new javax.swing.JMenuItem();
        clases_jpm = new javax.swing.JPopupMenu();
        item_agregarPropiedad = new javax.swing.JMenuItem();
        item_elimPropiedad = new javax.swing.JMenuItem();
        item_agregarMetodo = new javax.swing.JMenuItem();
        panel_contenedor = new javax.swing.JPanel();
        panel_editorDiagramas = new javax.swing.JPanel();
        panel_fuentes = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        lbl_fuente = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        jcb_fuentes = new javax.swing.JComboBox<>();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        lbl_color = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        btnColorFondo = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        lbl_tamano = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        spinner_tamano = new javax.swing.JSpinner();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jLabel1 = new javax.swing.JLabel();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        jcb_estiloLetra = new javax.swing.JComboBox<>();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(700, 32767));
        btn_cambiarEditor = new javax.swing.JButton();
        panel_opciones = new javax.swing.JPanel();
        btn_figuraProceso = new javax.swing.JButton();
        btn_figuraDecision = new javax.swing.JButton();
        btn_figuraInicio = new javax.swing.JButton();
        btn_figuraPrint = new javax.swing.JButton();
        btn_figuraFor = new javax.swing.JButton();
        btn_figuraWhile = new javax.swing.JButton();
        btn_figuraConectorH = new javax.swing.JButton();
        btn_figuraConectorV = new javax.swing.JButton();
        btn_figuraFin = new javax.swing.JButton();
        panel_trabajo = new javax.swing.JPanel();
        panel_diagramaDrag = new javax.swing.JPanel();
        panel_codigoDiagrama = new javax.swing.JPanel();
        scroll_codigoDiagrama = new javax.swing.JScrollPane();
        txt_area_codigoDiagrama = new javax.swing.JTextArea();
        panel_botones = new javax.swing.JPanel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(350, 32767));
        btn_pegar = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(200, 32767));
        btn_generarCodigo = new javax.swing.JButton();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        btn_cambiarPestana = new javax.swing.JButton();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(150, 32767));
        btn_crearVariable = new javax.swing.JButton();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        btn_crearOperacion = new javax.swing.JButton();
        panel_var_y_operaciones = new javax.swing.JPanel();
        panel_variables = new javax.swing.JPanel();
        scroll_listaVariables = new javax.swing.JScrollPane();
        lista_variables = new javax.swing.JList<>();
        panel_operaciones = new javax.swing.JPanel();
        scroll_listaOperaciones = new javax.swing.JScrollPane();
        lista_operaciones = new javax.swing.JList<>();
        panel_editorClases = new javax.swing.JPanel();
        panel_top_clases = new javax.swing.JPanel();
        btn_cambiarEditorDiag = new javax.swing.JButton();
        panel_clasesGeneradas = new javax.swing.JPanel();
        clases_scroll = new javax.swing.JScrollPane();
        jt_classes = new javax.swing.JTree();
        panel_opcionesClases = new javax.swing.JPanel();
        btn_nuevaClase = new javax.swing.JButton();
        btn_eliminarClase = new javax.swing.JButton();
        btn_herencia = new javax.swing.JButton();
        btn_agregarClasePanel = new javax.swing.JButton();
        panel_trabajoClases = new javax.swing.JPanel();
        panel_dragClases = new javax.swing.JPanel();
        panel_codigoClases = new javax.swing.JPanel();
        scroll_codigoClases = new javax.swing.JScrollPane();
        txtA_codigoClases = new javax.swing.JTextArea();
        panel_botonesClases = new javax.swing.JPanel();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(350, 32767));
        btn_generarCodigoClase = new javax.swing.JButton();
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        btn_cambiarPestanaClase = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        menuItem_archivoNuevo = new javax.swing.JMenuItem();
        menuItem_abrirArchivo = new javax.swing.JMenuItem();
        menuItem_guardarArchivo = new javax.swing.JMenuItem();
        menu_exportar = new javax.swing.JMenu();
        menuItem_exportarPDF = new javax.swing.JMenuItem();

        dlg_propiedades.setTitle("Propiedades");
        dlg_propiedades.setResizable(false);

        panel_propiedades.setBackground(new java.awt.Color(255, 255, 255));

        lbl_textoProp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_textoProp.setForeground(new java.awt.Color(51, 51, 51));
        lbl_textoProp.setText("Texto");

        lbl_colorProp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_colorProp.setForeground(new java.awt.Color(51, 51, 51));
        lbl_colorProp.setText("Color");

        lbl_fuenteProp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_fuenteProp.setForeground(new java.awt.Color(51, 51, 51));
        lbl_fuenteProp.setText("Fuente");

        lbl_textoFigura.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        lbl_textoFigura.setForeground(new java.awt.Color(51, 51, 51));
        lbl_textoFigura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_textoFigura.setText("jLabel2");

        lbl_altoProp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_altoProp.setForeground(new java.awt.Color(51, 51, 51));
        lbl_altoProp.setText("Alto (px)");

        lbl_sizeLetraProp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_sizeLetraProp.setForeground(new java.awt.Color(51, 51, 51));
        lbl_sizeLetraProp.setText("Tamaño de Letra");

        lbl_anchoProp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_anchoProp.setForeground(new java.awt.Color(51, 51, 51));
        lbl_anchoProp.setText("Ancho (px)");

        lbl_colorFigura.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        lbl_colorFigura.setForeground(new java.awt.Color(51, 51, 51));
        lbl_colorFigura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_colorFigura.setText("           ");

        lbl_fuenteFigura.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        lbl_fuenteFigura.setForeground(new java.awt.Color(51, 51, 51));
        lbl_fuenteFigura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fuenteFigura.setText("jLabel2");

        lbl_sizeLetraFigura.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        lbl_sizeLetraFigura.setForeground(new java.awt.Color(51, 51, 51));
        lbl_sizeLetraFigura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sizeLetraFigura.setText("jLabel2");

        lbl_anchoFigura.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        lbl_anchoFigura.setForeground(new java.awt.Color(51, 51, 51));
        lbl_anchoFigura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_anchoFigura.setText("jLabel2");

        lbl_altoFigura.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        lbl_altoFigura.setForeground(new java.awt.Color(51, 51, 51));
        lbl_altoFigura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_altoFigura.setText("jLabel2");

        javax.swing.GroupLayout panel_propiedadesLayout = new javax.swing.GroupLayout(panel_propiedades);
        panel_propiedades.setLayout(panel_propiedadesLayout);
        panel_propiedadesLayout.setHorizontalGroup(
            panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_propiedadesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_textoProp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_textoFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(panel_propiedadesLayout.createSequentialGroup()
                .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_fuenteProp)
                    .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_altoProp)
                            .addGroup(panel_propiedadesLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lbl_sizeLetraProp))
                            .addComponent(lbl_anchoProp))
                        .addComponent(lbl_colorProp, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_fuenteFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sizeLetraFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_anchoFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_altoFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_propiedadesLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lbl_colorFigura)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        panel_propiedadesLayout.setVerticalGroup(
            panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_propiedadesLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_textoProp)
                    .addComponent(lbl_textoFigura))
                .addGap(18, 18, 18)
                .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_colorProp)
                    .addComponent(lbl_colorFigura))
                .addGap(18, 18, 18)
                .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_fuenteProp)
                    .addComponent(lbl_fuenteFigura))
                .addGap(12, 12, 12)
                .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sizeLetraProp)
                    .addComponent(lbl_sizeLetraFigura))
                .addGap(18, 18, 18)
                .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_anchoProp)
                    .addComponent(lbl_anchoFigura))
                .addGap(18, 18, 18)
                .addGroup(panel_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_altoProp)
                    .addComponent(lbl_altoFigura))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlg_propiedadesLayout = new javax.swing.GroupLayout(dlg_propiedades.getContentPane());
        dlg_propiedades.getContentPane().setLayout(dlg_propiedadesLayout);
        dlg_propiedadesLayout.setHorizontalGroup(
            dlg_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_propiedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlg_propiedadesLayout.setVerticalGroup(
            dlg_propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_propiedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dlg_variables.setTitle("Crear Variable");
        dlg_variables.setMinimumSize(new java.awt.Dimension(393, 413));
        dlg_variables.setModal(true);
        dlg_variables.setResizable(false);

        panel_creacionVariables.setBackground(new java.awt.Color(255, 255, 255));
        panel_creacionVariables.setMaximumSize(new java.awt.Dimension(393, 413));
        panel_creacionVariables.setMinimumSize(new java.awt.Dimension(393, 413));

        lbl_nombreVariable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_nombreVariable.setForeground(new java.awt.Color(51, 51, 51));
        lbl_nombreVariable.setText("Nombre de Variable");

        txt_nombreVariable.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombreVariable.setForeground(new java.awt.Color(51, 51, 51));

        lbl_tipoVariable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_tipoVariable.setForeground(new java.awt.Color(51, 51, 51));
        lbl_tipoVariable.setText("Tipo de Variable");

        jcb_tipoVariable.setBackground(new java.awt.Color(255, 255, 255));
        jcb_tipoVariable.setForeground(new java.awt.Color(51, 51, 51));
        jcb_tipoVariable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "int", "double", "float", "String", "boolean" }));

        btn_confirmarVariable.setBackground(new java.awt.Color(255, 255, 255));
        btn_confirmarVariable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_confirmarVariable.setForeground(new java.awt.Color(51, 51, 51));
        btn_confirmarVariable.setText("Crear");
        btn_confirmarVariable.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        btn_confirmarVariable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confirmarVariable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_confirmarVariableMouseClicked(evt);
            }
        });

        btn_cancelarVariable.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelarVariable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cancelarVariable.setForeground(new java.awt.Color(51, 51, 51));
        btn_cancelarVariable.setText("Cancelar");
        btn_cancelarVariable.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        btn_cancelarVariable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelarVariable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelarVariableMouseClicked(evt);
            }
        });

        lbl_alcanceVariable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_alcanceVariable.setForeground(new java.awt.Color(51, 51, 51));
        lbl_alcanceVariable.setText("Alcance");

        jcb_alcanceVariable.setBackground(new java.awt.Color(255, 255, 255));
        jcb_alcanceVariable.setForeground(new java.awt.Color(51, 51, 51));
        jcb_alcanceVariable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "public", "private" }));

        lbl_titulo_crearVariable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_titulo_crearVariable.setForeground(new java.awt.Color(51, 51, 51));
        lbl_titulo_crearVariable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo_crearVariable.setText("Crear Variable");

        javax.swing.GroupLayout panel_creacionVariablesLayout = new javax.swing.GroupLayout(panel_creacionVariables);
        panel_creacionVariables.setLayout(panel_creacionVariablesLayout);
        panel_creacionVariablesLayout.setHorizontalGroup(
            panel_creacionVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_creacionVariablesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_creacionVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_creacionVariablesLayout.createSequentialGroup()
                        .addComponent(btn_cancelarVariable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_confirmarVariable))
                    .addGroup(panel_creacionVariablesLayout.createSequentialGroup()
                        .addGroup(panel_creacionVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_tipoVariable)
                            .addComponent(lbl_nombreVariable)
                            .addComponent(lbl_alcanceVariable))
                        .addGap(18, 18, 18)
                        .addGroup(panel_creacionVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombreVariable)
                            .addComponent(jcb_tipoVariable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcb_alcanceVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addComponent(lbl_titulo_crearVariable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_creacionVariablesLayout.setVerticalGroup(
            panel_creacionVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_creacionVariablesLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lbl_titulo_crearVariable)
                .addGap(30, 30, 30)
                .addGroup(panel_creacionVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombreVariable)
                    .addComponent(txt_nombreVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_creacionVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tipoVariable)
                    .addComponent(jcb_tipoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_creacionVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_alcanceVariable)
                    .addComponent(jcb_alcanceVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_creacionVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_confirmarVariable)
                    .addComponent(btn_cancelarVariable))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        dlg_variables.getContentPane().add(panel_creacionVariables, java.awt.BorderLayout.CENTER);

        dlg_operaciones.setTitle("Crear Operaciones");
        dlg_operaciones.setMinimumSize(new java.awt.Dimension(393, 413));
        dlg_operaciones.setModal(true);
        dlg_operaciones.setResizable(false);

        panel_creacionOperaciones.setBackground(new java.awt.Color(255, 255, 255));
        panel_creacionOperaciones.setMaximumSize(new java.awt.Dimension(393, 413));
        panel_creacionOperaciones.setMinimumSize(new java.awt.Dimension(393, 413));

        lbl_operador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_operador.setForeground(new java.awt.Color(51, 51, 51));
        lbl_operador.setText("Operador");

        lbl_var1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_var1.setForeground(new java.awt.Color(51, 51, 51));
        lbl_var1.setText("Variable 1");

        btn_confirmarOperacion.setBackground(new java.awt.Color(255, 255, 255));
        btn_confirmarOperacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_confirmarOperacion.setForeground(new java.awt.Color(51, 51, 51));
        btn_confirmarOperacion.setText("Crear");
        btn_confirmarOperacion.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        btn_confirmarOperacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confirmarOperacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_confirmarOperacionMouseClicked(evt);
            }
        });

        btn_cancelarOperacion.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelarOperacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cancelarOperacion.setForeground(new java.awt.Color(51, 51, 51));
        btn_cancelarOperacion.setText("Cancelar");
        btn_cancelarOperacion.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        btn_cancelarOperacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelarOperacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelarOperacionMouseClicked(evt);
            }
        });

        lbl_var2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_var2.setForeground(new java.awt.Color(51, 51, 51));
        lbl_var2.setText("Variable 2");

        lbl_titulo_crearOperacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_titulo_crearOperacion.setForeground(new java.awt.Color(51, 51, 51));
        lbl_titulo_crearOperacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo_crearOperacion.setText("Crear Operacion");

        lbl_resultado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_resultado.setForeground(new java.awt.Color(51, 51, 51));
        lbl_resultado.setText("Resultado");

        jcb_operador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "/", "+", "-" }));

        jcb_var2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcb_var1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcb_resultado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panel_creacionOperacionesLayout = new javax.swing.GroupLayout(panel_creacionOperaciones);
        panel_creacionOperaciones.setLayout(panel_creacionOperacionesLayout);
        panel_creacionOperacionesLayout.setHorizontalGroup(
            panel_creacionOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_titulo_crearOperacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_creacionOperacionesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panel_creacionOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_resultado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_var1)
                    .addComponent(lbl_operador)
                    .addComponent(lbl_var2))
                .addGap(18, 18, 18)
                .addGroup(panel_creacionOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_operador, 0, 184, Short.MAX_VALUE)
                    .addComponent(jcb_var2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcb_var1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcb_resultado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_creacionOperacionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelarOperacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_confirmarOperacion)
                .addGap(120, 120, 120))
        );
        panel_creacionOperacionesLayout.setVerticalGroup(
            panel_creacionOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_creacionOperacionesLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lbl_titulo_crearOperacion)
                .addGap(29, 29, 29)
                .addGroup(panel_creacionOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_operador)
                    .addComponent(jcb_operador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_creacionOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_var1)
                    .addComponent(jcb_var1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_creacionOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_var2)
                    .addComponent(jcb_var2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_creacionOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_resultado)
                    .addComponent(jcb_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panel_creacionOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_confirmarOperacion)
                    .addComponent(btn_cancelarOperacion))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlg_operacionesLayout = new javax.swing.GroupLayout(dlg_operaciones.getContentPane());
        dlg_operaciones.getContentPane().setLayout(dlg_operacionesLayout);
        dlg_operacionesLayout.setHorizontalGroup(
            dlg_operacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
            .addGroup(dlg_operacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlg_operacionesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_creacionOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        dlg_operacionesLayout.setVerticalGroup(
            dlg_operacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
            .addGroup(dlg_operacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlg_operacionesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_creacionOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jmItem_cambiarColor.setText("Cambiar Color");
        jmItem_cambiarColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItem_cambiarColorActionPerformed(evt);
            }
        });
        figura_jpm.add(jmItem_cambiarColor);

        jmItem_cambiarTexto.setText("Cambiar Texto");
        jmItem_cambiarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItem_cambiarTextoActionPerformed(evt);
            }
        });
        figura_jpm.add(jmItem_cambiarTexto);

        jmItem_cambiarFuente.setText("Cambiar Fuente");
        jmItem_cambiarFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItem_cambiarFuenteActionPerformed(evt);
            }
        });
        figura_jpm.add(jmItem_cambiarFuente);
        figura_jpm.add(sep1);

        jmItem_copiar.setText("Copiar");
        jmItem_copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItem_copiarActionPerformed(evt);
            }
        });
        figura_jpm.add(jmItem_copiar);

        jmItem_eliminar.setText("Eliminar");
        jmItem_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItem_eliminarActionPerformed(evt);
            }
        });
        figura_jpm.add(jmItem_eliminar);

        jmItem_propiedades.setText("Propiedades");
        jmItem_propiedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItem_propiedadesActionPerformed(evt);
            }
        });
        figura_jpm.add(jmItem_propiedades);

        item_agregarPropiedad.setText("Agregar Propiedad");
        clases_jpm.add(item_agregarPropiedad);

        item_elimPropiedad.setText("Eliminar Propiedad");
        clases_jpm.add(item_elimPropiedad);

        item_agregarMetodo.setText("Agregar Metodo");
        clases_jpm.add(item_agregarMetodo);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Traductor UML");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        panel_contenedor.setBackground(new java.awt.Color(255, 255, 255));
        panel_contenedor.setLayout(new java.awt.CardLayout());

        panel_editorDiagramas.setLayout(new java.awt.BorderLayout());

        panel_fuentes.setBackground(new java.awt.Color(236, 236, 236));
        panel_fuentes.setPreferredSize(new java.awt.Dimension(894, 55));
        panel_fuentes.setLayout(new javax.swing.BoxLayout(panel_fuentes, javax.swing.BoxLayout.LINE_AXIS));
        panel_fuentes.add(filler1);

        lbl_fuente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_fuente.setForeground(new java.awt.Color(0, 0, 0));
        lbl_fuente.setText("Fuente");
        panel_fuentes.add(lbl_fuente);
        panel_fuentes.add(filler2);

        jcb_fuentes.setBackground(new java.awt.Color(236, 236, 236));
        jcb_fuentes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcb_fuentes.setForeground(new java.awt.Color(51, 51, 51));
        jcb_fuentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arial", "Arial Black", "Courier New", "Times New Roman", "Georgia", "Verdana", "Tahoma", "Impact", "Century Gothic", "Trebuchet MS", "Monospaced" }));
        jcb_fuentes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jcb_fuentes.setMaximumSize(new java.awt.Dimension(150, 25));
        jcb_fuentes.setMinimumSize(new java.awt.Dimension(100, 25));
        jcb_fuentes.setPreferredSize(new java.awt.Dimension(100, 25));
        jcb_fuentes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_fuentesItemStateChanged(evt);
            }
        });
        panel_fuentes.add(jcb_fuentes);
        panel_fuentes.add(filler3);

        lbl_color.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_color.setForeground(new java.awt.Color(0, 0, 0));
        lbl_color.setText("Color");
        panel_fuentes.add(lbl_color);
        panel_fuentes.add(filler4);

        btnColorFondo.setBackground(new java.awt.Color(0, 0, 0));
        btnColorFondo.setText(" ");
        btnColorFondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        btnColorFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnColorFondo.setFocusPainted(false);
        btnColorFondo.setMaximumSize(new java.awt.Dimension(25, 25));
        btnColorFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnColorFondoMouseClicked(evt);
            }
        });
        panel_fuentes.add(btnColorFondo);
        panel_fuentes.add(filler5);

        lbl_tamano.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tamano.setForeground(new java.awt.Color(0, 0, 0));
        lbl_tamano.setText("Tamaño");
        panel_fuentes.add(lbl_tamano);
        panel_fuentes.add(filler6);

        spinner_tamano.setModel(new javax.swing.SpinnerNumberModel(8, 8, 24, 2));
        spinner_tamano.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        spinner_tamano.setMaximumSize(new java.awt.Dimension(65, 25));
        spinner_tamano.setMinimumSize(new java.awt.Dimension(65, 25));
        spinner_tamano.setPreferredSize(new java.awt.Dimension(65, 25));
        spinner_tamano.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinner_tamanoStateChanged(evt);
            }
        });
        panel_fuentes.add(spinner_tamano);
        panel_fuentes.add(filler7);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Estilo");
        panel_fuentes.add(jLabel1);
        panel_fuentes.add(filler11);

        jcb_estiloLetra.setBackground(new java.awt.Color(236, 236, 236));
        jcb_estiloLetra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcb_estiloLetra.setForeground(new java.awt.Color(51, 51, 51));
        jcb_estiloLetra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Negrita", "Italica" }));
        jcb_estiloLetra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jcb_estiloLetra.setMaximumSize(new java.awt.Dimension(120, 25));
        jcb_estiloLetra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_estiloLetraItemStateChanged(evt);
            }
        });
        panel_fuentes.add(jcb_estiloLetra);
        panel_fuentes.add(filler12);

        btn_cambiarEditor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_cambiarEditor.setForeground(new java.awt.Color(153, 153, 153));
        btn_cambiarEditor.setText("Ir a Editor de Clases >>");
        btn_cambiarEditor.setToolTipText("Cambiar a Editor de Clases");
        btn_cambiarEditor.setBorderPainted(false);
        btn_cambiarEditor.setContentAreaFilled(false);
        btn_cambiarEditor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cambiarEditor.setFocusPainted(false);
        btn_cambiarEditor.setFocusable(false);
        btn_cambiarEditor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cambiarEditorMouseClicked(evt);
            }
        });
        panel_fuentes.add(btn_cambiarEditor);

        panel_editorDiagramas.add(panel_fuentes, java.awt.BorderLayout.PAGE_START);

        panel_opciones.setBackground(new java.awt.Color(255, 255, 255));
        panel_opciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        panel_opciones.setMinimumSize(new java.awt.Dimension(400, 447));
        panel_opciones.setPreferredSize(new java.awt.Dimension(350, 529));
        panel_opciones.setLayout(new java.awt.GridLayout(5, 2, 5, 10));

        btn_figuraProceso.setBackground(new java.awt.Color(255, 255, 255));
        btn_figuraProceso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_figuraProceso.setForeground(new java.awt.Color(0, 0, 0));
        btn_figuraProceso.setIcon(new ImageIcon(getClass().getResource("/imagenes/001.png")));
        btn_figuraProceso.setText("PROCESO");
        btn_figuraProceso.setBorder(null);
        btn_figuraProceso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_figuraProceso.setFocusPainted(false);
        btn_figuraProceso.setFocusable(false);
        btn_figuraProceso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_figuraProceso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_figuraProcesoMouseClicked(evt);
            }
        });
        panel_opciones.add(btn_figuraProceso);

        btn_figuraDecision.setBackground(new java.awt.Color(255, 255, 255));
        btn_figuraDecision.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_figuraDecision.setForeground(new java.awt.Color(0, 0, 0));
        btn_figuraDecision.setIcon(new ImageIcon(getClass().getResource("/imagenes/002.png")));
        btn_figuraDecision.setText("DECISION");
        btn_figuraDecision.setBorder(null);
        btn_figuraDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_figuraDecision.setFocusCycleRoot(true);
        btn_figuraDecision.setFocusPainted(false);
        btn_figuraDecision.setFocusable(false);
        btn_figuraDecision.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_figuraDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_figuraDecisionMouseClicked(evt);
            }
        });
        panel_opciones.add(btn_figuraDecision);

        btn_figuraInicio.setBackground(new java.awt.Color(255, 255, 255));
        btn_figuraInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_figuraInicio.setForeground(new java.awt.Color(0, 0, 0));
        btn_figuraInicio.setIcon(new ImageIcon(getClass().getResource("/imagenes/000.png")));
        btn_figuraInicio.setText("INICIO");
        btn_figuraInicio.setBorder(null);
        btn_figuraInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_figuraInicio.setFocusPainted(false);
        btn_figuraInicio.setFocusable(false);
        btn_figuraInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_figuraInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_figuraInicioMouseClicked(evt);
            }
        });
        panel_opciones.add(btn_figuraInicio);

        btn_figuraPrint.setBackground(new java.awt.Color(255, 255, 255));
        btn_figuraPrint.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_figuraPrint.setForeground(new java.awt.Color(0, 0, 0));
        btn_figuraPrint.setIcon(new ImageIcon(getClass().getResource("/imagenes/003.png")));
        btn_figuraPrint.setText("SOUT");
        btn_figuraPrint.setBorder(null);
        btn_figuraPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_figuraPrint.setFocusPainted(false);
        btn_figuraPrint.setFocusable(false);
        btn_figuraPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_figuraPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_figuraPrintMouseClicked(evt);
            }
        });
        panel_opciones.add(btn_figuraPrint);

        btn_figuraFor.setBackground(new java.awt.Color(255, 255, 255));
        btn_figuraFor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_figuraFor.setForeground(new java.awt.Color(0, 0, 0));
        btn_figuraFor.setIcon(new ImageIcon(getClass().getResource("/imagenes/004.png")));
        btn_figuraFor.setText("FOR");
        btn_figuraFor.setBorder(null);
        btn_figuraFor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_figuraFor.setFocusPainted(false);
        btn_figuraFor.setFocusable(false);
        btn_figuraFor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_figuraFor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_figuraForMouseClicked(evt);
            }
        });
        panel_opciones.add(btn_figuraFor);

        btn_figuraWhile.setBackground(new java.awt.Color(255, 255, 255));
        btn_figuraWhile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_figuraWhile.setForeground(new java.awt.Color(0, 0, 0));
        btn_figuraWhile.setIcon(new ImageIcon(getClass().getResource("/imagenes/005.png")));
        btn_figuraWhile.setText("WHILE");
        btn_figuraWhile.setBorder(null);
        btn_figuraWhile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_figuraWhile.setFocusPainted(false);
        btn_figuraWhile.setFocusable(false);
        btn_figuraWhile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_figuraWhile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_figuraWhileMouseClicked(evt);
            }
        });
        panel_opciones.add(btn_figuraWhile);

        btn_figuraConectorH.setBackground(new java.awt.Color(255, 255, 255));
        btn_figuraConectorH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_figuraConectorH.setForeground(new java.awt.Color(102, 102, 102));
        btn_figuraConectorH.setText("——————");
        btn_figuraConectorH.setToolTipText("Conector Horizontal");
        btn_figuraConectorH.setBorder(null);
        btn_figuraConectorH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_figuraConectorH.setFocusPainted(false);
        btn_figuraConectorH.setFocusable(false);
        btn_figuraConectorH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_figuraConectorHMouseClicked(evt);
            }
        });
        panel_opciones.add(btn_figuraConectorH);

        btn_figuraConectorV.setBackground(new java.awt.Color(255, 255, 255));
        btn_figuraConectorV.setForeground(new java.awt.Color(51, 51, 51));
        btn_figuraConectorV.setText("|");
        btn_figuraConectorV.setToolTipText("Conector Vertical");
        btn_figuraConectorV.setBorder(null);
        btn_figuraConectorV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_figuraConectorV.setFocusPainted(false);
        btn_figuraConectorV.setFocusable(false);
        btn_figuraConectorV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_figuraConectorVMouseClicked(evt);
            }
        });
        panel_opciones.add(btn_figuraConectorV);

        btn_figuraFin.setBackground(new java.awt.Color(255, 255, 255));
        btn_figuraFin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_figuraFin.setForeground(new java.awt.Color(0, 0, 0));
        btn_figuraFin.setIcon(new ImageIcon(getClass().getResource("/imagenes/002.png")));
        btn_figuraFin.setText("FIN");
        btn_figuraFin.setBorder(null);
        btn_figuraFin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_figuraFin.setFocusPainted(false);
        btn_figuraFin.setFocusable(false);
        btn_figuraFin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_figuraFin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_figuraFinMouseClicked(evt);
            }
        });
        panel_opciones.add(btn_figuraFin);

        panel_editorDiagramas.add(panel_opciones, java.awt.BorderLayout.LINE_START);

        panel_trabajo.setBackground(new java.awt.Color(255, 255, 255));
        panel_trabajo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        panel_trabajo.setMinimumSize(new java.awt.Dimension(400, 480));
        panel_trabajo.setPreferredSize(new java.awt.Dimension(400, 480));
        panel_trabajo.setLayout(new java.awt.CardLayout());

        panel_diagramaDrag.setBackground(new java.awt.Color(255, 255, 255));
        panel_diagramaDrag.setLayout(null);
        panel_trabajo.add(panel_diagramaDrag, "cardDiagrama");

        panel_codigoDiagrama.setBackground(new java.awt.Color(255, 255, 255));
        panel_codigoDiagrama.setMinimumSize(new java.awt.Dimension(700, 478));
        panel_codigoDiagrama.setPreferredSize(new java.awt.Dimension(700, 478));
        panel_codigoDiagrama.setLayout(new java.awt.BorderLayout());

        scroll_codigoDiagrama.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        txt_area_codigoDiagrama.setEditable(false);
        txt_area_codigoDiagrama.setBackground(new java.awt.Color(255, 255, 255));
        txt_area_codigoDiagrama.setColumns(20);
        txt_area_codigoDiagrama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_area_codigoDiagrama.setForeground(new java.awt.Color(51, 51, 51));
        txt_area_codigoDiagrama.setRows(5);
        txt_area_codigoDiagrama.setMinimumSize(new java.awt.Dimension(230, 21));
        txt_area_codigoDiagrama.setPreferredSize(new java.awt.Dimension(230, 89));
        scroll_codigoDiagrama.setViewportView(txt_area_codigoDiagrama);

        panel_codigoDiagrama.add(scroll_codigoDiagrama, java.awt.BorderLayout.CENTER);

        panel_trabajo.add(panel_codigoDiagrama, "cardCodigo");

        panel_editorDiagramas.add(panel_trabajo, java.awt.BorderLayout.CENTER);

        panel_botones.setBackground(new java.awt.Color(255, 255, 255));
        panel_botones.setPreferredSize(new java.awt.Dimension(894, 55));
        panel_botones.setLayout(new javax.swing.BoxLayout(panel_botones, javax.swing.BoxLayout.LINE_AXIS));
        panel_botones.add(filler9);

        btn_pegar.setBackground(new java.awt.Color(255, 255, 255));
        btn_pegar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_pegar.setForeground(new java.awt.Color(51, 51, 51));
        btn_pegar.setText("Pegar");
        btn_pegar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        btn_pegar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pegar.setFocusPainted(false);
        btn_pegar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pegarMouseClicked(evt);
            }
        });
        panel_botones.add(btn_pegar);
        panel_botones.add(filler8);

        btn_generarCodigo.setBackground(new java.awt.Color(255, 255, 255));
        btn_generarCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_generarCodigo.setForeground(new java.awt.Color(51, 51, 51));
        btn_generarCodigo.setText("Generar Codigo");
        btn_generarCodigo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        btn_generarCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_generarCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_generarCodigoMouseClicked(evt);
            }
        });
        panel_botones.add(btn_generarCodigo);
        panel_botones.add(filler10);

        btn_cambiarPestana.setBackground(new java.awt.Color(255, 255, 255));
        btn_cambiarPestana.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cambiarPestana.setForeground(new java.awt.Color(51, 51, 51));
        btn_cambiarPestana.setText("Ver Codigo");
        btn_cambiarPestana.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        btn_cambiarPestana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cambiarPestana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cambiarPestanaMouseClicked(evt);
            }
        });
        panel_botones.add(btn_cambiarPestana);
        panel_botones.add(filler13);

        btn_crearVariable.setBackground(new java.awt.Color(255, 255, 255));
        btn_crearVariable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_crearVariable.setForeground(new java.awt.Color(51, 51, 51));
        btn_crearVariable.setText("Crear Variable");
        btn_crearVariable.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        btn_crearVariable.setFocusPainted(false);
        btn_crearVariable.setFocusable(false);
        btn_crearVariable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_crearVariableMouseClicked(evt);
            }
        });
        panel_botones.add(btn_crearVariable);
        panel_botones.add(filler14);

        btn_crearOperacion.setBackground(new java.awt.Color(255, 255, 255));
        btn_crearOperacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_crearOperacion.setForeground(new java.awt.Color(51, 51, 51));
        btn_crearOperacion.setText("Crear Operacion");
        btn_crearOperacion.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        btn_crearOperacion.setFocusPainted(false);
        btn_crearOperacion.setFocusable(false);
        btn_crearOperacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_crearOperacionMouseClicked(evt);
            }
        });
        panel_botones.add(btn_crearOperacion);

        panel_editorDiagramas.add(panel_botones, java.awt.BorderLayout.PAGE_END);

        panel_var_y_operaciones.setBackground(new java.awt.Color(255, 255, 255));
        panel_var_y_operaciones.setPreferredSize(new java.awt.Dimension(200, 482));
        panel_var_y_operaciones.setRequestFocusEnabled(false);
        panel_var_y_operaciones.setLayout(new java.awt.GridLayout(2, 0));

        panel_variables.setBackground(new java.awt.Color(255, 255, 255));
        panel_variables.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Variables", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N
        panel_variables.setLayout(new java.awt.BorderLayout());

        lista_variables.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scroll_listaVariables.setViewportView(lista_variables);

        panel_variables.add(scroll_listaVariables, java.awt.BorderLayout.CENTER);

        panel_var_y_operaciones.add(panel_variables);

        panel_operaciones.setBackground(new java.awt.Color(255, 255, 255));
        panel_operaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operaciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N
        panel_operaciones.setLayout(new java.awt.BorderLayout());

        lista_operaciones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scroll_listaOperaciones.setViewportView(lista_operaciones);

        panel_operaciones.add(scroll_listaOperaciones, java.awt.BorderLayout.CENTER);

        panel_var_y_operaciones.add(panel_operaciones);

        panel_editorDiagramas.add(panel_var_y_operaciones, java.awt.BorderLayout.LINE_END);

        panel_contenedor.add(panel_editorDiagramas, "contenedorEditorDiagramas");

        panel_editorClases.setBackground(new java.awt.Color(255, 255, 255));
        panel_editorClases.setLayout(new java.awt.BorderLayout());

        panel_top_clases.setBackground(new java.awt.Color(236, 236, 236));
        panel_top_clases.setPreferredSize(new java.awt.Dimension(894, 55));
        panel_top_clases.setLayout(new javax.swing.BoxLayout(panel_top_clases, javax.swing.BoxLayout.LINE_AXIS));

        btn_cambiarEditorDiag.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_cambiarEditorDiag.setForeground(new java.awt.Color(153, 153, 153));
        btn_cambiarEditorDiag.setText("<< Ir a Editor de Diagramas");
        btn_cambiarEditorDiag.setToolTipText("Cambiar a Editor de Diagramas");
        btn_cambiarEditorDiag.setBorderPainted(false);
        btn_cambiarEditorDiag.setContentAreaFilled(false);
        btn_cambiarEditorDiag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cambiarEditorDiag.setFocusPainted(false);
        btn_cambiarEditorDiag.setFocusable(false);
        btn_cambiarEditorDiag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cambiarEditorDiagMouseClicked(evt);
            }
        });
        panel_top_clases.add(btn_cambiarEditorDiag);

        panel_editorClases.add(panel_top_clases, java.awt.BorderLayout.PAGE_START);

        panel_clasesGeneradas.setBackground(new java.awt.Color(255, 255, 255));
        panel_clasesGeneradas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clases Generadas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        panel_clasesGeneradas.setPreferredSize(new java.awt.Dimension(250, 386));
        panel_clasesGeneradas.setLayout(new java.awt.GridLayout(2, 0));

        clases_scroll.setViewportView(jt_classes);

        panel_clasesGeneradas.add(clases_scroll);

        panel_opcionesClases.setBackground(new java.awt.Color(255, 255, 255));
        panel_opcionesClases.setLayout(new java.awt.GridLayout(2, 2, 5, 10));

        btn_nuevaClase.setBackground(new java.awt.Color(255, 255, 255));
        btn_nuevaClase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_nuevaClase.setForeground(new java.awt.Color(51, 51, 51));
        btn_nuevaClase.setText("Nueva Clase");
        btn_nuevaClase.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        btn_nuevaClase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevaClaseMouseClicked(evt);
            }
        });
        panel_opcionesClases.add(btn_nuevaClase);

        btn_eliminarClase.setBackground(new java.awt.Color(255, 255, 255));
        btn_eliminarClase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_eliminarClase.setForeground(new java.awt.Color(51, 51, 51));
        btn_eliminarClase.setText("Eliminar Clase");
        btn_eliminarClase.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        btn_eliminarClase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminarClaseMouseClicked(evt);
            }
        });
        panel_opcionesClases.add(btn_eliminarClase);

        btn_herencia.setBackground(new java.awt.Color(255, 255, 255));
        btn_herencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_herencia.setForeground(new java.awt.Color(51, 51, 51));
        btn_herencia.setText("Herencia");
        btn_herencia.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        panel_opcionesClases.add(btn_herencia);

        btn_agregarClasePanel.setBackground(new java.awt.Color(255, 255, 255));
        btn_agregarClasePanel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_agregarClasePanel.setForeground(new java.awt.Color(51, 51, 51));
        btn_agregarClasePanel.setText("Agregar");
        btn_agregarClasePanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        btn_agregarClasePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_agregarClasePanelMouseClicked(evt);
            }
        });
        panel_opcionesClases.add(btn_agregarClasePanel);

        panel_clasesGeneradas.add(panel_opcionesClases);

        panel_editorClases.add(panel_clasesGeneradas, java.awt.BorderLayout.LINE_START);

        panel_trabajoClases.setBackground(new java.awt.Color(255, 255, 255));
        panel_trabajoClases.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        panel_trabajoClases.setLayout(new java.awt.CardLayout());

        panel_dragClases.setBackground(new java.awt.Color(255, 255, 255));
        panel_dragClases.setLayout(null);
        panel_trabajoClases.add(panel_dragClases, "panelClasesDrag");

        panel_codigoClases.setBackground(new java.awt.Color(255, 255, 255));
        panel_codigoClases.setLayout(new java.awt.BorderLayout());

        scroll_codigoClases.setBackground(new java.awt.Color(255, 255, 255));
        scroll_codigoClases.setForeground(new java.awt.Color(0, 0, 0));

        txtA_codigoClases.setBackground(new java.awt.Color(255, 255, 255));
        txtA_codigoClases.setColumns(20);
        txtA_codigoClases.setForeground(new java.awt.Color(0, 0, 0));
        txtA_codigoClases.setRows(5);
        txtA_codigoClases.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        scroll_codigoClases.setViewportView(txtA_codigoClases);

        panel_codigoClases.add(scroll_codigoClases, java.awt.BorderLayout.CENTER);

        panel_trabajoClases.add(panel_codigoClases, "panelCodigoClases");

        panel_editorClases.add(panel_trabajoClases, java.awt.BorderLayout.CENTER);

        panel_botonesClases.setBackground(new java.awt.Color(255, 255, 255));
        panel_botonesClases.setPreferredSize(new java.awt.Dimension(894, 55));
        panel_botonesClases.setLayout(new javax.swing.BoxLayout(panel_botonesClases, javax.swing.BoxLayout.LINE_AXIS));
        panel_botonesClases.add(filler15);

        btn_generarCodigoClase.setBackground(new java.awt.Color(255, 255, 255));
        btn_generarCodigoClase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_generarCodigoClase.setForeground(new java.awt.Color(51, 51, 51));
        btn_generarCodigoClase.setText("Generar Codigo");
        btn_generarCodigoClase.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        btn_generarCodigoClase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_generarCodigoClase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_generarCodigoClaseMouseClicked(evt);
            }
        });
        panel_botonesClases.add(btn_generarCodigoClase);
        panel_botonesClases.add(filler17);

        btn_cambiarPestanaClase.setBackground(new java.awt.Color(255, 255, 255));
        btn_cambiarPestanaClase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cambiarPestanaClase.setForeground(new java.awt.Color(51, 51, 51));
        btn_cambiarPestanaClase.setText("Ver Codigo");
        btn_cambiarPestanaClase.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        btn_cambiarPestanaClase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cambiarPestanaClase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cambiarPestanaClaseMouseClicked(evt);
            }
        });
        panel_botonesClases.add(btn_cambiarPestanaClase);

        panel_editorClases.add(panel_botonesClases, java.awt.BorderLayout.PAGE_END);

        panel_contenedor.add(panel_editorClases, "contenedorEditorClases");

        getContentPane().add(panel_contenedor, java.awt.BorderLayout.CENTER);

        menu_archivo.setText("Archivo");

        menuItem_archivoNuevo.setText("Archivo Nuevo");
        menuItem_archivoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_archivoNuevoActionPerformed(evt);
            }
        });
        menu_archivo.add(menuItem_archivoNuevo);

        menuItem_abrirArchivo.setText("Abrir Archivo");
        menuItem_abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_abrirArchivoActionPerformed(evt);
            }
        });
        menu_archivo.add(menuItem_abrirArchivo);

        menuItem_guardarArchivo.setText("Guardar Archivo");
        menuItem_guardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_guardarArchivoActionPerformed(evt);
            }
        });
        menu_archivo.add(menuItem_guardarArchivo);

        menubar.add(menu_archivo);

        menu_exportar.setText("Exportar");

        menuItem_exportarPDF.setText("Exportar PDF");
        menuItem_exportarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_exportarPDFActionPerformed(evt);
            }
        });
        menu_exportar.add(menuItem_exportarPDF);

        menubar.add(menu_exportar);

        setJMenuBar(menubar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItem_exportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_exportarPDFActionPerformed
	if (modoDiagrama && labelFiguras.isEmpty()) {
	    JOptionPane.showMessageDialog(this, "No hay elementos en el diagrama para exportar!", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    return;
	}
	JFileChooser fileChooser = new JFileChooser();
	fileChooser.setDialogTitle("Exportar PDF");
	fileChooser.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));

	if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
	    File archivoPDF = fileChooser.getSelectedFile();
	    if (!archivoPDF.getAbsolutePath().endsWith(".pdf")) {
		archivoPDF = new File(archivoPDF.getAbsolutePath() + ".pdf");
	    }

	    JPanel panelAImprimir = (modoDiagrama ? panel_diagramaDrag : panel_dragClases);
	    int ancho = panelAImprimir.getWidth();
	    int alto = panelAImprimir.getHeight();

	    try (PDDocument documento = new PDDocument()) {
		PDPage pagina = new PDPage(PDRectangle.A4);
		documento.addPage(pagina);

		BufferedImage buferImagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = buferImagen.createGraphics();
		panelAImprimir.printAll(g2);
		g2.dispose();

		PDImageXObject imagen = LosslessFactory.createFromImage(documento, buferImagen);

		try (PDPageContentStream contentStream = new PDPageContentStream(documento, pagina)) {
		    contentStream.drawImage(imagen, 0, 0, pagina.getMediaBox().getWidth(), pagina.getMediaBox().getHeight());
		}

		documento.save(archivoPDF);
		JOptionPane.showMessageDialog(null, "Se exporto el PDF correctamente", "Exportado", JOptionPane.INFORMATION_MESSAGE);

	    } catch (IOException ex) {
		Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }//GEN-LAST:event_menuItem_exportarPDFActionPerformed

    private void menuItem_abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_abrirArchivoActionPerformed
	JFileChooser fileChooser = new JFileChooser();
	fileChooser.setDialogTitle("Abrir Archivo");
	fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo UML", "diagm"));
	if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileChooser.getSelectedFile()))) {

		Object objetoLeido = ois.readObject();
		CardLayout layout = (CardLayout) panel_contenedor.getLayout();

		if (objetoLeido instanceof ArrayList) {
		    this.figuras = (ArrayList<Figura>) objetoLeido;
		    panel_diagramaDrag.removeAll();
		    labelFiguras.clear();

		    for (Figura figura : figuras) {
			agregarFiguraPanel(figura);
		    }
		    layout.show(panel_contenedor, "contenedorEditorDiagramas");
		    modoDiagrama = true;
		} else if (objetoLeido instanceof DefaultTreeModel) {
		    DefaultTreeModel modeloCargado = (DefaultTreeModel) objetoLeido;
		    jt_classes.setModel(modeloCargado);

		    clases.clear();
		    DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) modeloCargado.getRoot();
		    for (int i = 0; i < raiz.getChildCount(); i++) {
			DefaultMutableTreeNode nodoClase = (DefaultMutableTreeNode) raiz.getChildAt(i);
			if (nodoClase.getUserObject() instanceof Clase) {
			    clases.add((Clase) nodoClase.getUserObject());
			}
		    }
		    layout.show(panel_contenedor, "contenedorEditorClases");
		    modoDiagrama = false;
		}
		panel_diagramaDrag.revalidate();
		panel_diagramaDrag.repaint();

	    } catch (Exception ex) {
		JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + ex.getMessage());
	    }
	}
    }//GEN-LAST:event_menuItem_abrirArchivoActionPerformed

    private void menuItem_guardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_guardarArchivoActionPerformed
	if (figuras.isEmpty()) {
	    JOptionPane.showMessageDialog(this, "Todavia no se han agregado elementos en el diagrama", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    return;
	}
	JFileChooser fileChooser = new JFileChooser();
	fileChooser.setDialogTitle("Guardar Archivo");
	fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo UML", "diagm"));
	if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
	    File archivo = fileChooser.getSelectedFile();
	    if (!archivo.getAbsolutePath().endsWith(".diagm")) {
		archivo = new File(archivo.getAbsolutePath() + ".diagm");
	    }
	    try (FileOutputStream fos = new FileOutputStream(archivo); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
		if (modoDiagrama) {
		    oos.writeObject(figuras);
		} else {
		    oos.writeObject(jt_classes.getModel());
		}
		JOptionPane.showMessageDialog(this, "Proyecto Guardado correctamente", "Archivo guardado", JOptionPane.INFORMATION_MESSAGE);
	    } catch (IOException ex) {
		Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }//GEN-LAST:event_menuItem_guardarArchivoActionPerformed

    private void menuItem_archivoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_archivoNuevoActionPerformed
	int seleccion = JOptionPane.showConfirmDialog(this, "Se borrara todo el proyecto!", "Nuevo Archivo", JOptionPane.YES_NO_OPTION);
	if (seleccion == JOptionPane.YES_OPTION) {
	    figuras.clear();
	    labelFiguras.clear();
	    panel_diagramaDrag.removeAll();
	    panel_diagramaDrag.revalidate();
	    panel_diagramaDrag.repaint();

	    DefaultMutableTreeNode raizVacia = new DefaultMutableTreeNode("Proyecto");
	    jt_classes.setModel(new DefaultTreeModel(raizVacia));
	    clases.clear();
	}
    }//GEN-LAST:event_menuItem_archivoNuevoActionPerformed

    private void btn_figuraProcesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_figuraProcesoMouseClicked
	Figura proceso = new Figura(TipoFigura.PROCESO, "PROCESO", elegirColorPredeterminado(), 20, 50, ANCHO_FIGURA, ALTO_FIGURA);
	figuras.add(proceso);
	figuraSeleccionada = agregarFiguraPanel(proceso);
    }//GEN-LAST:event_btn_figuraProcesoMouseClicked

    private void btn_figuraDecisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_figuraDecisionMouseClicked
	Figura decision = new Figura(TipoFigura.DECISION, "DECISION", elegirColorPredeterminado(), 30, 100, ANCHO_FIGURA, ALTO_FIGURA);
	figuras.add(decision);
	figuraSeleccionada = agregarFiguraPanel(decision);
    }//GEN-LAST:event_btn_figuraDecisionMouseClicked

    private void spinner_tamanoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinner_tamanoStateChanged
	if (figuraSeleccionada != null) {
	    int tamano = (int) spinner_tamano.getValue();
	    figuraSeleccionada.getFigura().setTamanoLetra(tamano);
	    figuraSeleccionada.actualizarFuente();
	}
    }//GEN-LAST:event_spinner_tamanoStateChanged

    private void jcb_estiloLetraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_estiloLetraItemStateChanged
	if (figuraSeleccionada != null) {
	    int seleccionado = jcb_estiloLetra.getSelectedIndex();
	    figuraSeleccionada.getFigura().setEstiloLetra(seleccionado);
	    figuraSeleccionada.actualizarFuente();
	}
    }//GEN-LAST:event_jcb_estiloLetraItemStateChanged

    private void btnColorFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnColorFondoMouseClicked
	if (figuraSeleccionada != null) {
	    Color seleccionado = JColorChooser.showDialog(this, "Selecciona un color", Color.WHITE);
	    if (seleccionado != null) {
		String colorHex = String.format("#%02x%02x%02x", seleccionado.getRed(), seleccionado.getGreen(), seleccionado.getBlue());
		figuraSeleccionada.actualizarColorFondo(colorHex);
		btnColorFondo.setBackground(seleccionado);
	    }

	}
    }//GEN-LAST:event_btnColorFondoMouseClicked

    private void btn_figuraInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_figuraInicioMouseClicked
	boolean existente = false;
	for (int i = 0; i < figuras.size(); i++) {
	    if (figuras.get(i).getTipo() == TipoFigura.INICIO) {
		existente = true;
	    }
	}
	if (!existente) {
	    Figura inicio = new Figura(TipoFigura.INICIO, "INICIO", elegirColorPredeterminado(), 30, 100, ANCHO_FIGURA, ALTO_FIGURA);
	    figuras.add(inicio);
	    figuraSeleccionada = agregarFiguraPanel(inicio);
	}
    }//GEN-LAST:event_btn_figuraInicioMouseClicked

    private void btn_figuraForMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_figuraForMouseClicked
	Figura bucleFor = new Figura(TipoFigura.BUCLE_FOR, "FOR", elegirColorPredeterminado(), 10, 40, ANCHO_FIGURA, ALTO_FIGURA);
	figuras.add(bucleFor);
	figuraSeleccionada = agregarFiguraPanel(bucleFor);
    }//GEN-LAST:event_btn_figuraForMouseClicked

    private void btn_figuraPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_figuraPrintMouseClicked
	Figura sout = new Figura(TipoFigura.IMPRESION_PANTALLA, "SOUT", elegirColorPredeterminado(), 102, 32, ANCHO_FIGURA, ALTO_FIGURA);
	figuras.add(sout);
	figuraSeleccionada = agregarFiguraPanel(sout);
    }//GEN-LAST:event_btn_figuraPrintMouseClicked

    private void jcb_fuentesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_fuentesItemStateChanged
	if (figuraSeleccionada != null) {
	    String fuente = (String) jcb_fuentes.getSelectedItem();
	    figuraSeleccionada.getFigura().setFuente(fuente);
	    figuraSeleccionada.actualizarFuente();
	}
    }//GEN-LAST:event_jcb_fuentesItemStateChanged

    private void btn_pegarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pegarMouseClicked
	if (figuraCopiada != null) {
	    Figura nuevaFigura = new Figura(figuraCopiada.getTipo(),
		    figuraCopiada.getTexto(), figuraCopiada.getColorFondo(), figuraCopiada.getX() + 30,
		    figuraCopiada.getY() + 30, figuraCopiada.getAncho(), figuraCopiada.getAlto());
	    nuevaFigura.setFuente(figuraCopiada.getFuente());
	    nuevaFigura.setTamanoLetra(figuraCopiada.getTamanoLetra());
	    nuevaFigura.setEstiloLetra(figuraCopiada.getEstiloLetra());

	    figuras.add(nuevaFigura);
	    figuraSeleccionada = agregarFiguraPanel(nuevaFigura);
	}
    }//GEN-LAST:event_btn_pegarMouseClicked

    private void btn_cambiarPestanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cambiarPestanaMouseClicked
	CardLayout layout_panel_trabajo = (CardLayout) panel_trabajo.getLayout();
	if (esEditorDeDiagrama) {
	    layout_panel_trabajo.show(panel_trabajo, "cardCodigo");
	    btn_cambiarPestana.setText("Ver Diagrama");
	    esEditorDeDiagrama = false;
	} else {
	    layout_panel_trabajo.show(panel_trabajo, "cardDiagrama");
	    btn_cambiarPestana.setText("Ver Codigo");
	    esEditorDeDiagrama = true;
	}
    }//GEN-LAST:event_btn_cambiarPestanaMouseClicked

    private void btn_cambiarEditorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cambiarEditorMouseClicked
	CardLayout layout_contenedor = (CardLayout) panel_contenedor.getLayout();
	layout_contenedor.show(panel_contenedor, "contenedorEditorClases");
	modoDiagrama = false;
    }//GEN-LAST:event_btn_cambiarEditorMouseClicked

    private void btn_figuraConectorHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_figuraConectorHMouseClicked
	Figura conectorH = new Figura(TipoFigura.CONECTOR_HORIZONTAL, "", "#000000", 140, 100, 150, 5);
	figuras.add(conectorH);
	figuraSeleccionada = agregarFiguraPanel(conectorH);
    }//GEN-LAST:event_btn_figuraConectorHMouseClicked

    private void btn_figuraConectorVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_figuraConectorVMouseClicked
	Figura conectorV = new Figura(TipoFigura.CONECTOR_VERTICAL, "", "#000000", 140, 100, 5, 150);
	figuras.add(conectorV);
	figuraSeleccionada = agregarFiguraPanel(conectorV);
    }//GEN-LAST:event_btn_figuraConectorVMouseClicked

    private void btn_figuraWhileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_figuraWhileMouseClicked
	Figura bucleWhile = new Figura(TipoFigura.BUCLE_WHILE, "WHILE", elegirColorPredeterminado(), 210, 100, ANCHO_FIGURA, ALTO_FIGURA);
	figuras.add(bucleWhile);
	figuraSeleccionada = agregarFiguraPanel(bucleWhile);
    }//GEN-LAST:event_btn_figuraWhileMouseClicked

    private void btn_figuraFinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_figuraFinMouseClicked

	boolean existente = false;
	for (int i = 0; i < figuras.size(); i++) {
	    if (figuras.get(i).getTipo() == TipoFigura.FIN) {
		existente = true;
	    }
	}
	if (!existente) {
	    Figura fin = new Figura(TipoFigura.FIN, "FIN", elegirColorPredeterminado(), 210, 100, ANCHO_FIGURA, ALTO_FIGURA);
	    figuras.add(fin);
	    figuraSeleccionada = agregarFiguraPanel(fin);
	}
    }//GEN-LAST:event_btn_figuraFinMouseClicked

    private void btn_crearVariableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearVariableMouseClicked
	if (modoDiagrama) {
	    jcb_alcanceVariable.setSelectedIndex(0);
	    jcb_alcanceVariable.setEnabled(false);
	}
	dlg_variables.pack();
	dlg_variables.setLocationRelativeTo(null);
	dlg_variables.setVisible(true);
    }//GEN-LAST:event_btn_crearVariableMouseClicked

    private void btn_cancelarVariableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarVariableMouseClicked
	txt_nombreVariable.setText("");
	jcb_tipoVariable.setSelectedIndex(0);
	dlg_variables.dispose();
    }//GEN-LAST:event_btn_cancelarVariableMouseClicked

    private void btn_confirmarVariableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_confirmarVariableMouseClicked
	if (txt_nombreVariable.getText().trim().length() == 0) {
	    JOptionPane.showMessageDialog(this, "El Nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
	    return;
	}
	String nombre = txt_nombreVariable.getText().replace(" ", "").trim();
	String tipo = (String) jcb_tipoVariable.getSelectedItem();
	Variable variable = new Variable(tipo, nombre, "");
	DefaultListModel modelo = (DefaultListModel) lista_variables.getModel();
	modelo.addElement(variable);
	JOptionPane.showMessageDialog(this, "Variable Agregada", "Exito", JOptionPane.INFORMATION_MESSAGE);

	txt_nombreVariable.setText("");
	jcb_tipoVariable.setSelectedIndex(0);
	dlg_variables.dispose();
    }//GEN-LAST:event_btn_confirmarVariableMouseClicked

    private void btn_confirmarOperacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_confirmarOperacionMouseClicked
	if (lista_variables.getModel().getSize() == 0) {
	    JOptionPane.showMessageDialog(this, "No puedes operar sin variables creadas.");
	    return;
	}

	Variable var1 = (Variable) jcb_var1.getSelectedItem();
	Variable var2 = (Variable) jcb_var2.getSelectedItem();
	Variable resultado = (Variable) jcb_resultado.getSelectedItem();
	String operador = jcb_operador.getSelectedItem().toString();

	if (var1 != null && var2 != null && resultado != null) {
	    Operacion nuevaOperacion = new Operacion(operador, var1, var2, resultado);

	    DefaultListModel modeloListaOperaciones = (DefaultListModel) lista_operaciones.getModel();
	    modeloListaOperaciones.addElement(nuevaOperacion);
	}
    }//GEN-LAST:event_btn_confirmarOperacionMouseClicked

    private void btn_cancelarOperacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarOperacionMouseClicked
	dlg_operaciones.dispose();
    }//GEN-LAST:event_btn_cancelarOperacionMouseClicked

    private void btn_cambiarEditorDiagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cambiarEditorDiagMouseClicked
	CardLayout layout_contenedor = (CardLayout) panel_contenedor.getLayout();
	panel_diagramaDrag.removeAll();
	panel_diagramaDrag.revalidate();
	panel_diagramaDrag.repaint();
	layout_contenedor.show(panel_contenedor, "contenedorEditorDiagramas");
	modoDiagrama = true;
    }//GEN-LAST:event_btn_cambiarEditorDiagMouseClicked

    private void jmItem_cambiarColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItem_cambiarColorActionPerformed
	if (figuraSeleccionada != null) {
	    Color seleccionado = JColorChooser.showDialog(this, "Selecciona un color", Color.WHITE);
	    if (seleccionado != null) {
		String colorHex = String.format("#%02x%02x%02x", seleccionado.getRed(), seleccionado.getGreen(), seleccionado.getBlue());
		figuraSeleccionada.actualizarColorFondo(colorHex);
		btnColorFondo.setBackground(seleccionado);
	    }
	}
    }//GEN-LAST:event_jmItem_cambiarColorActionPerformed

    private void jmItem_cambiarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItem_cambiarTextoActionPerformed
	String texto = JOptionPane.showInputDialog(this, "Nuevo Texto:", "Nuevo Texto", JOptionPane.QUESTION_MESSAGE);
	if (texto != null) {
	    if (texto.trim().length() > 0) {
		figuraSeleccionada.actualizarTexto(texto);
	    } else {
		JOptionPane.showMessageDialog(this, "No puedes ingresar texto vacio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    }
	}
    }//GEN-LAST:event_jmItem_cambiarTextoActionPerformed

    private void jmItem_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItem_copiarActionPerformed
	if (figuraSeleccionada != null) {
	    Figura figuraNormal = figuraSeleccionada.getFigura();

	    figuraCopiada = new Figura(figuraNormal.getTipo(), figuraNormal.getTexto(), figuraNormal.getColorFondo(),
		    figuraNormal.getX(), figuraNormal.getY(), figuraNormal.getAncho(), figuraNormal.getAlto());

	    figuraCopiada.setFuente(figuraNormal.getFuente());
	    figuraCopiada.setEstiloLetra(figuraNormal.getEstiloLetra());
	    figuraCopiada.setTamanoLetra(figuraNormal.getTamanoLetra());
	}
    }//GEN-LAST:event_jmItem_copiarActionPerformed

    private void jmItem_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItem_eliminarActionPerformed
	if (figuraSeleccionada != null) {
	    panel_diagramaDrag.remove(figuraSeleccionada);
	    labelFiguras.remove(figuraSeleccionada);
	    figuras.remove(figuraSeleccionada.getFigura());

	    panel_diagramaDrag.repaint();
	    figuraSeleccionada = null;
	}
    }//GEN-LAST:event_jmItem_eliminarActionPerformed

    private void btn_generarCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generarCodigoMouseClicked
	String codigo = "";
	Figura figuraInicio = null;
	Figura figuraFin = null;

	for (Figura figura : figuras) {
	    if (figura.getTipo() == TipoFigura.INICIO) {
		figuraInicio = figura;
	    } else if (figura.getTipo() == TipoFigura.FIN) {
		figuraFin = figura;
	    }
	}

	if (figuraInicio == null || figuraFin == null) {
	    JOptionPane.showMessageDialog(this, "No existe un Elemento Inicio/Fin en el diagrama.", "Error", JOptionPane.ERROR_MESSAGE);
	    return;
	}

	codigo += figuraInicio.obtenerCodigo() + "\n";

	DefaultListModel modeloVariables = (DefaultListModel) lista_variables.getModel();
	if (modeloVariables.getSize() > 0) {
	    for (int i = 0; i < modeloVariables.getSize(); i++) {
		Variable variable = (Variable) modeloVariables.getElementAt(i);
		codigo += "        " + variable.getTipo() + " " + variable.getNombre() + ";\n";
	    }
	    codigo += "\n";
	}

	DefaultListModel modeloOps = (DefaultListModel) lista_operaciones.getModel();
	if (modeloOps.getSize() > 0) {
	    for (int i = 0; i < modeloOps.getSize(); i++) {
		Operacion op = (Operacion) modeloOps.getElementAt(i);
		codigo += "        " + op.toString() + "\n";
	    }
	    codigo += "\n";
	}

	for (Figura figura : figuras) {
	    if (figura.getTipo() != TipoFigura.INICIO && figura.getTipo() != TipoFigura.FIN) {
		codigo += figura.obtenerCodigo() + "\n";
	    }
	}

	codigo += figuraFin.obtenerCodigo();

	txt_area_codigoDiagrama.setText(codigo);
	JOptionPane.showMessageDialog(this, "Código generado con éxito...", "Generación Completa", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_generarCodigoMouseClicked

    private void btn_crearOperacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearOperacionMouseClicked
	if (lista_variables.getModel().getSize() > 0) {

	    DefaultListModel modeloLista = (DefaultListModel) lista_variables.getModel();

	    DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
	    DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
	    DefaultComboBoxModel modeloResultado = new DefaultComboBoxModel();

	    for (int i = 0; i < modeloLista.getSize(); i++) {
		Variable variable = (Variable) modeloLista.getElementAt(i);

		modelo1.addElement(variable);
		modelo2.addElement(variable);
		modeloResultado.addElement(variable);
	    }

	    jcb_var1.setModel(modelo1);
	    jcb_var2.setModel(modelo2);
	    jcb_resultado.setModel(modeloResultado);

	    dlg_operaciones.setLocationRelativeTo(this);
	    dlg_operaciones.setVisible(true);

	} else {
	    JOptionPane.showMessageDialog(this, "No hay variables para crear operacion", "Sin Variables", JOptionPane.WARNING_MESSAGE);
	}
    }//GEN-LAST:event_btn_crearOperacionMouseClicked

    private void jmItem_cambiarFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItem_cambiarFuenteActionPerformed
	if (figuraSeleccionada != null) {
	    String[] fuentes = {"Arial", "Arial Black", "Courier New", "Times New Roman", "Georgia", "Verdana",
		"Tahoma", "Impact", "Century Gothic", "Trebuchet MS", "Monospaced"};

	    String seleccion = (String) JOptionPane.showInputDialog(this, "Selecciona la fuente deseada", "Cambiar Fuente", JOptionPane.QUESTION_MESSAGE,
		    null, fuentes, figuraSeleccionada.getFont().getFamily()
	    );

	    if (seleccion != null) {
		int estiloActual = figuraSeleccionada.getFont().getStyle();
		int tamanoActual = figuraSeleccionada.getFont().getSize();

		Font fuente = new Font(seleccion, estiloActual, tamanoActual);

		figuraSeleccionada.setFont(fuente);

		figuraSeleccionada.getFigura().setFuente(seleccion);

		figuraSeleccionada.repaint();
	    }
	}
    }//GEN-LAST:event_jmItem_cambiarFuenteActionPerformed

    private void btn_nuevaClaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevaClaseMouseClicked
	String nombreClase = JOptionPane.showInputDialog(this, "Escribe el nombre de la clase", "Crear Clase", JOptionPane.PLAIN_MESSAGE);
	if (nombreClase == null) {
	    return;
	}
	boolean existe = false;
	for (Clase clase : clases) {
	    if (clase.getNombre().equals(nombreClase)) {
		existe = true;
		break;
	    }
	}
	if (existe) {
	    JOptionPane.showMessageDialog(this, "Clase existente", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    return;
	}
	if (nombreClase.trim().length() != 0) {
	    DefaultTreeModel modelo = (DefaultTreeModel) jt_classes.getModel();
	    DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) modelo.getRoot();

	    Clase clase = new Clase(nombreClase.replace(" ", ""));
	    clases.add(clase);

	    DefaultMutableTreeNode nuevaClase = new DefaultMutableTreeNode(clase);
	    DefaultMutableTreeNode propiedades = new DefaultMutableTreeNode("Propiedades");
	    DefaultMutableTreeNode methods = new DefaultMutableTreeNode("Metodos");

	    nuevaClase.add(propiedades);
	    nuevaClase.add(methods);

	    raiz.add(nuevaClase);
	    modelo.reload();
	    JOptionPane.showMessageDialog(this, "Clase creada correctamente", "Clase creada", JOptionPane.INFORMATION_MESSAGE);
	} else {
	    JOptionPane.showMessageDialog(this, "Error al crear la clase", "Error", JOptionPane.ERROR_MESSAGE);
	}
    }//GEN-LAST:event_btn_nuevaClaseMouseClicked

    private void btn_eliminarClaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarClaseMouseClicked
	DefaultTreeModel modelo = (DefaultTreeModel) jt_classes.getModel();
	DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) jt_classes.getLastSelectedPathComponent();

	if (nodoSeleccionado == null || nodoSeleccionado.isRoot()) {
	    JOptionPane.showMessageDialog(this, "Selecciona una clase para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    return;
	}

	Clase claseAEliminar = obtenerClase(nodoSeleccionado);

	if (claseAEliminar != null) {
	    clases.remove(claseAEliminar);

	    modelo.removeNodeFromParent(nodoSeleccionado);

	    JOptionPane.showMessageDialog(this, "Clase eliminada correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
	}

    }//GEN-LAST:event_btn_eliminarClaseMouseClicked

    private void jmItem_propiedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItem_propiedadesActionPerformed
	if (figuraSeleccionada != null) {
	    lbl_textoFigura.setText(figuraSeleccionada.getText());
	    lbl_colorFigura.setOpaque(true);
	    lbl_colorFigura.setBackground(figuraSeleccionada.getBackground());
	    lbl_colorFigura.setText(figuraSeleccionada.getFigura().getColorFondo());

	    lbl_fuenteFigura.setText(figuraSeleccionada.getFigura().getFuente());
	    lbl_tamano.setText(String.format("%d", figuraSeleccionada.getFigura().getTamanoLetra()));

	    lbl_anchoFigura.setText(figuraSeleccionada.getWidth() + " px");
	    lbl_altoFigura.setText(figuraSeleccionada.getHeight() + " px");

	    dlg_propiedades.pack();
	    dlg_propiedades.setVisible(true);

	}
    }//GEN-LAST:event_jmItem_propiedadesActionPerformed

    private void btn_generarCodigoClaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generarCodigoClaseMouseClicked
	// TODO add your handling code here:
    }//GEN-LAST:event_btn_generarCodigoClaseMouseClicked

    private void btn_cambiarPestanaClaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cambiarPestanaClaseMouseClicked
	DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) jt_classes.getLastSelectedPathComponent();

	if (nodoSeleccionado == null) {
	    JOptionPane.showMessageDialog(this, "Selecciona una clase en el árbol para ver el código.");
	    return;
	}

	Clase claseSeleccionada = obtenerClase(nodoSeleccionado);

	if (claseSeleccionada != null) {
	    String codigoGenerado = claseSeleccionada.obtenerCodigo();

	    txtA_codigoClases.setText(codigoGenerado);
	    txtA_codigoClases.setCaretPosition(0);

	    CardLayout layout = (CardLayout) panel_trabajoClases.getLayout();
	    layout.show(panel_trabajoClases, "panelCodigoClases");
	}
    }//GEN-LAST:event_btn_cambiarPestanaClaseMouseClicked

    private void btn_agregarClasePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarClasePanelMouseClicked
	DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) jt_classes.getLastSelectedPathComponent();

	if (nodoSeleccionado == null) {
	    JOptionPane.showMessageDialog(this, "Selecciona una clase.");
	    return;
	}

	Clase claseOriginal = obtenerClase(nodoSeleccionado);
	if (claseOriginal != null) {

	    DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(claseOriginal);
	    DefaultMutableTreeNode nodoPropiedades = new DefaultMutableTreeNode("Propiedades");
	    DefaultMutableTreeNode nodoMetodos = new DefaultMutableTreeNode("Metodos");

	    for (Variable variable : claseOriginal.getPropiedades()) {
		nodoPropiedades.add(new DefaultMutableTreeNode(variable));
	    }

	    for (Metodo metodo : claseOriginal.getMetodos()) {
		nodoMetodos.add(new DefaultMutableTreeNode(metodo));
	    }

	    raiz.add(nodoPropiedades);
	    raiz.add(nodoMetodos);
	    DefaultTreeModel modeloDrag = new DefaultTreeModel(raiz);

	    JTree arbolDrag = new javax.swing.JTree(modeloDrag);
	    arbolDrag.setSize(160, 120);
	    arbolDrag.setLocation(20, 20);

	    arbolDrag.setComponentPopupMenu(clases_jpm);
	    Point puntoPresionado = new java.awt.Point();
	    arbolDrag.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
		    puntoPresionado.x = e.getX();
		    puntoPresionado.y = e.getY();
		}
	    });

	    arbolDrag.addMouseMotionListener(new MouseAdapter() {
		@Override
		public void mouseDragged(MouseEvent e) {
		    int x = arbolDrag.getX() + e.getX() - puntoPresionado.x;
		    int y = arbolDrag.getY() + e.getY() - puntoPresionado.y;
		    arbolDrag.setLocation(x, y);
		}
	    });

	    panel_dragClases.add(arbolDrag);
	    panel_dragClases.repaint();
	}
    }//GEN-LAST:event_btn_agregarClasePanelMouseClicked

    private String elegirColorPredeterminado() {
	Random rand = new Random();
	String colorHex;
	colorHex = coloresPredeterminados[(rand.nextInt(0, coloresPredeterminados.length))];
	return colorHex;
    }

    private Clase obtenerClase(DefaultMutableTreeNode nodo) {
	if (nodo.getUserObject() instanceof Clase) {
	    Clase temp = (Clase) nodo.getUserObject();
	    for (Clase clase : clases) {
		if (clase.getNombre().equals(temp.getNombre())) {
		    return clase;
		}
	    }
	    return null;
	} else {
	    return null;
	}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColorFondo;
    private javax.swing.JButton btn_agregarClasePanel;
    private javax.swing.JButton btn_cambiarEditor;
    private javax.swing.JButton btn_cambiarEditorDiag;
    private javax.swing.JButton btn_cambiarPestana;
    private javax.swing.JButton btn_cambiarPestanaClase;
    private javax.swing.JButton btn_cancelarOperacion;
    private javax.swing.JButton btn_cancelarVariable;
    private javax.swing.JButton btn_confirmarOperacion;
    private javax.swing.JButton btn_confirmarVariable;
    private javax.swing.JButton btn_crearOperacion;
    private javax.swing.JButton btn_crearVariable;
    private javax.swing.JButton btn_eliminarClase;
    private javax.swing.JButton btn_figuraConectorH;
    private javax.swing.JButton btn_figuraConectorV;
    private javax.swing.JButton btn_figuraDecision;
    private javax.swing.JButton btn_figuraFin;
    private javax.swing.JButton btn_figuraFor;
    private javax.swing.JButton btn_figuraInicio;
    private javax.swing.JButton btn_figuraPrint;
    private javax.swing.JButton btn_figuraProceso;
    private javax.swing.JButton btn_figuraWhile;
    private javax.swing.JButton btn_generarCodigo;
    private javax.swing.JButton btn_generarCodigoClase;
    private javax.swing.JButton btn_herencia;
    private javax.swing.JButton btn_nuevaClase;
    private javax.swing.JButton btn_pegar;
    private javax.swing.JPopupMenu clases_jpm;
    private javax.swing.JScrollPane clases_scroll;
    private javax.swing.JDialog dlg_operaciones;
    private javax.swing.JDialog dlg_propiedades;
    private javax.swing.JDialog dlg_variables;
    private javax.swing.JPopupMenu figura_jpm;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JMenuItem item_agregarMetodo;
    private javax.swing.JMenuItem item_agregarPropiedad;
    private javax.swing.JMenuItem item_elimPropiedad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jcb_alcanceVariable;
    private javax.swing.JComboBox<String> jcb_estiloLetra;
    private javax.swing.JComboBox<String> jcb_fuentes;
    private javax.swing.JComboBox<String> jcb_operador;
    private javax.swing.JComboBox<String> jcb_resultado;
    private javax.swing.JComboBox<String> jcb_tipoVariable;
    private javax.swing.JComboBox<String> jcb_var1;
    private javax.swing.JComboBox<String> jcb_var2;
    private javax.swing.JMenuItem jmItem_cambiarColor;
    private javax.swing.JMenuItem jmItem_cambiarFuente;
    private javax.swing.JMenuItem jmItem_cambiarTexto;
    private javax.swing.JMenuItem jmItem_copiar;
    private javax.swing.JMenuItem jmItem_eliminar;
    private javax.swing.JMenuItem jmItem_propiedades;
    private javax.swing.JTree jt_classes;
    private javax.swing.JLabel lbl_alcanceVariable;
    private javax.swing.JLabel lbl_altoFigura;
    private javax.swing.JLabel lbl_altoProp;
    private javax.swing.JLabel lbl_anchoFigura;
    private javax.swing.JLabel lbl_anchoProp;
    private javax.swing.JLabel lbl_color;
    private javax.swing.JLabel lbl_colorFigura;
    private javax.swing.JLabel lbl_colorProp;
    private javax.swing.JLabel lbl_fuente;
    private javax.swing.JLabel lbl_fuenteFigura;
    private javax.swing.JLabel lbl_fuenteProp;
    private javax.swing.JLabel lbl_nombreVariable;
    private javax.swing.JLabel lbl_operador;
    private javax.swing.JLabel lbl_resultado;
    private javax.swing.JLabel lbl_sizeLetraFigura;
    private javax.swing.JLabel lbl_sizeLetraProp;
    private javax.swing.JLabel lbl_tamano;
    private javax.swing.JLabel lbl_textoFigura;
    private javax.swing.JLabel lbl_textoProp;
    private javax.swing.JLabel lbl_tipoVariable;
    private javax.swing.JLabel lbl_titulo_crearOperacion;
    private javax.swing.JLabel lbl_titulo_crearVariable;
    private javax.swing.JLabel lbl_var1;
    private javax.swing.JLabel lbl_var2;
    private javax.swing.JList<String> lista_operaciones;
    private javax.swing.JList<String> lista_variables;
    private javax.swing.JMenuItem menuItem_abrirArchivo;
    private javax.swing.JMenuItem menuItem_archivoNuevo;
    private javax.swing.JMenuItem menuItem_exportarPDF;
    private javax.swing.JMenuItem menuItem_guardarArchivo;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_exportar;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPanel panel_botonesClases;
    private javax.swing.JPanel panel_clasesGeneradas;
    private javax.swing.JPanel panel_codigoClases;
    private javax.swing.JPanel panel_codigoDiagrama;
    private javax.swing.JPanel panel_contenedor;
    private javax.swing.JPanel panel_creacionOperaciones;
    private javax.swing.JPanel panel_creacionVariables;
    private javax.swing.JPanel panel_diagramaDrag;
    private javax.swing.JPanel panel_dragClases;
    private javax.swing.JPanel panel_editorClases;
    private javax.swing.JPanel panel_editorDiagramas;
    private javax.swing.JPanel panel_fuentes;
    private javax.swing.JPanel panel_opciones;
    private javax.swing.JPanel panel_opcionesClases;
    private javax.swing.JPanel panel_operaciones;
    private javax.swing.JPanel panel_propiedades;
    private javax.swing.JPanel panel_top_clases;
    private javax.swing.JPanel panel_trabajo;
    private javax.swing.JPanel panel_trabajoClases;
    private javax.swing.JPanel panel_var_y_operaciones;
    private javax.swing.JPanel panel_variables;
    private javax.swing.JScrollPane scroll_codigoClases;
    private javax.swing.JScrollPane scroll_codigoDiagrama;
    private javax.swing.JScrollPane scroll_listaOperaciones;
    private javax.swing.JScrollPane scroll_listaVariables;
    private javax.swing.JPopupMenu.Separator sep1;
    private javax.swing.JSpinner spinner_tamano;
    private javax.swing.JTextArea txtA_codigoClases;
    private javax.swing.JTextArea txt_area_codigoDiagrama;
    private javax.swing.JTextField txt_nombreVariable;
    // End of variables declaration//GEN-END:variables
}
