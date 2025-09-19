package com.edu.upc.proyectBook.view;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class OptionBar extends JMenuBar {
	private static long serialVersionUID = 1L;
	private EventsMainWindow eventsMainWindow;
	/*Definicion de los menus*/
	private JMenu optionMenuBook;
	private JMenu optionImport;
	private JMenu optionExport;
	private JMenu optionReport;
	
	private JMenuItem optionCreateBook;
	private JMenuItem optionUpdateBook;
	private JMenuItem optionFindBookBySerialName;
	
	private JMenuItem optionImportFilePlain;
	private JMenuItem optionImportCSV;
	private JMenuItem optionImportXML;
	private JMenuItem optionImportJSON;
	private JMenuItem optionImportSer;
	
	private JMenuItem optionExportFilePlain;
	private JMenuItem optionExportCSV;
	private JMenuItem optionExportXML;
	private JMenuItem optionExportJSON;
	private JMenuItem optionExportSer;
	
	public OptionBar(MainWindow mainWindow) {
		this.eventsMainWindow = new EventsMainWindow(mainWindow);
		this.optionMenuBook = new JMenu("Administrar libro");
		this.optionMenuBook.setIcon(new ImageIcon("resources/img/icons/libro.png"));
		this.optionImport = new  JMenu("Importar");
		this.optionImport.setIcon(new ImageIcon("resources/img/icons/load.png"));
		this.optionExport = new JMenu("Exportar");
		this.optionExport.setIcon(new ImageIcon("resources/img/icons/dump.png"));
		this.optionReport = new JMenu("Reportes");
		this.optionReport.setIcon(new ImageIcon("resources/img/icons/reports.png"));
		
		this.optionCreateBook = new JMenuItem("Crear libro");
		this.optionCreateBook.setActionCommand(EventsMainWindow.ADD_BOOK);
		this.optionCreateBook.addActionListener(eventsMainWindow);
		this.optionCreateBook.setIcon(new ImageIcon("resources/img/icons/anadir-libro.png"));
		
		this.optionUpdateBook = new JMenuItem("Actualizar libro");
		this.optionUpdateBook.setIcon(new ImageIcon("resources/img/icons/actualizar-libro.png"));
		
		this.optionFindBookBySerialName = new JMenuItem("Buscar libro por nombre");
		this.optionFindBookBySerialName.setIcon(new ImageIcon("resources/img/icons/buscar-libro.png"));
		
		this.optionImportFilePlain = new JMenuItem("Archivo plano");
		this.optionImportFilePlain.setActionCommand(EventsMainWindow.LOAD_BOOK_PLAIN);
		this.optionImportFilePlain.addActionListener(new EventsMainWindow(mainWindow));
		this.optionImportFilePlain.setIcon(new ImageIcon("resources/img/icons/filePlain.png"));

		
		this.optionImportCSV = new JMenuItem("CSV");	
		this.optionImportCSV.setActionCommand(EventsMainWindow.LOAD_BOOK_CSV);
		this.optionImportCSV.addActionListener(new EventsMainWindow(mainWindow));
		this.optionImportCSV.setIcon(new ImageIcon("resources/img/icons/fileExcel.png"));

		
		this.optionImportXML = new JMenuItem("XML");
		this.optionImportXML.setActionCommand(EventsMainWindow.LOAD_BOOK_XML);
		this.optionImportXML.addActionListener(new EventsMainWindow(mainWindow));
		this.optionImportXML.setIcon(new ImageIcon("resources/img/icons/fileXML.png"));
	
		
		this.optionImportJSON = new JMenuItem("JSON");
		this.optionImportJSON.setActionCommand(EventsMainWindow.LOAD_BOOK_JSON);
		this.optionImportJSON.setIcon(new ImageIcon("resources/img/icons/fileJSON.png"));

		
		this.optionImportSer = new JMenuItem("Serializado");
		this.optionImportSer.setActionCommand(EventsMainWindow.LOAD_BOOK_SERIALIZATE);
		this.optionImportSer.addActionListener(new EventsMainWindow(mainWindow));
		this.optionImportSer.setIcon(new ImageIcon("resources/img/icons/fileSer.png"));

		
		
		this.optionExportFilePlain = new JMenuItem("FilePlain");
		this.optionExportFilePlain.setIcon(new ImageIcon("resources/img/icons/filePlain.png"));

		this.optionExportCSV = new JMenuItem("CSV");
		this.optionExportCSV.setIcon(new ImageIcon("resources/img/icons/fileExcel.png"));
		
		this.optionExportXML = new JMenuItem("XML");
		this.optionExportXML.setIcon(new ImageIcon("resources/img/icons/fileXML.png"));
		
		this.optionExportJSON = new JMenuItem("JSON");
		this.optionExportJSON.setIcon(new ImageIcon("resources/img/icons/fileJSON.png"));
		
		this.optionExportSer = new JMenuItem("Serializado");
		this.optionExportSer.setIcon(new ImageIcon("resources/img/icons/fileSer.png"));
		
		this.optionMenuBook.add(optionCreateBook);
		this.optionMenuBook.add(optionUpdateBook);
		this.optionMenuBook.add(optionFindBookBySerialName);
		
		this.optionImport.add(optionImportFilePlain);
		this.optionImport.add(optionImportCSV);
		this.optionImport.add(optionImportXML);
		this.optionImport.add(optionImportJSON);
		this.optionImport.add(optionImportSer);
		
		this.optionExport.add(optionExportFilePlain);
		this.optionExport.add(optionExportCSV);
		this.optionExport.add(optionExportXML);
		this.optionExport.add(optionExportJSON);
		this.optionExport.add(optionExportSer);
		
		this.add(optionMenuBook);
		this.add(optionImport);
		this.add(optionExport);
		this.add(optionReport);
	}
	
	

}
