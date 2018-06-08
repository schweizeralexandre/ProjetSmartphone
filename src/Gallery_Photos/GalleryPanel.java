package Gallery_Photos;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.MainFrame;



public class GalleryPanel extends JPanel {

	private JPanel menuPanel = new JPanel() ;
	private JPanel galeryPanel = new JPanel() ;
	private JPanel photoPanel = new JPanel() ;
	


	private JButton returnButton = new GaleryButton("Images/back_button.png") ;
	private JLabel titleLabel = new JLabel("Ma Galerie") ;
	private JButton addButton = new GaleryButton("Images/add_button.png") ;
	private JButton deleteButton = new GaleryButton("Images/delete_button.png") ;

	private CardLayout display = new CardLayout() ;

	private String[] CardList = {"GalleryPanel","FullScreenPanel"} ;

	ArrayList <String> ImageGallery ;





	public GalleryPanel() {

try {
	ImageGallery =  deserialize() ;
} catch (Exception e) {
	// TODO: handle exception
	ImageGallery = new ArrayList<String>() ;
}
		
		galeryPanel.setLayout(new BorderLayout());
		menuPanel.setLayout(new GridLayout(1, 3)) ;


		menuPanel.setBackground(Color.white) ;
		galeryPanel.setBackground(Color.lightGray) ;


		galeryPanel.add(photoPanel, BorderLayout.CENTER) ;
		photoPanel.setBackground(Color.lightGray);
		galeryPanel.add(menuPanel,BorderLayout.NORTH);


		titleLabel.setHorizontalAlignment(SwingConstants.CENTER) ;
		titleLabel.setFont(new Font("Helvetica Neue",  Font.BOLD, 12)) ;
		titleLabel.setForeground(new Color(51, 153, 255)) ;


		menuPanel.add(returnButton) ;
		menuPanel.add(titleLabel) ;
		menuPanel.add(addButton) ;



		addButton.addActionListener(new Import()) ;

		returnButton.addActionListener(new Retour()) ;



		photoPanel.setLayout(new FlowLayout()) ;
		setLayout(display) ;
		add(galeryPanel,CardList[0]) ;

		//photoPanel.setLayout(new GridLayout(4,4)) ;

		displayImage();








	}

	void displayImage() {
		photoPanel.removeAll();
		for (int i = 0; i < ImageGallery.size(); i++) {

			photoPanel.add(new Photo(ImageGallery.get(i),CardList,display,this, i)) ;
			System.out.println(ImageGallery.get(i));
			//			photoPanel.add(new JButton()) ;
		}
	}

	private static void serialize (ArrayList <String> ImageGallery) throws IOException {
		FileOutputStream fichier = new FileOutputStream("sauvegardeImages/sauvegardeImages.ser") ;
		BufferedOutputStream bfichier = new BufferedOutputStream(fichier) ;
		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier) ;
		obfichier.writeObject(ImageGallery) ;
		obfichier.close() ;
	}

	public ArrayList <String> deserialize() throws IOException, ClassNotFoundException
	{
		ArrayList <String> ImageGallery = new ArrayList() ;
		FileInputStream ffichier = new FileInputStream("sauvegardeImages/sauvegardeImages.ser") ;
		BufferedInputStream bfichier = new BufferedInputStream(ffichier) ;
		ObjectInputStream obfichier = new ObjectInputStream(bfichier) ;
		//obfichier.readObject();
		ImageGallery = (ArrayList) obfichier.readObject() ;
		obfichier.close() ;
		return ImageGallery ;

	}




	class GaleryButton extends JButton {

		private String path;

		public GaleryButton(String str) {
			path = str;

			setCursor(new Cursor(Cursor.HAND_CURSOR));
			setCursor(new Cursor(Cursor.HAND_CURSOR));
			setOpaque(false);
			setContentAreaFilled(false);
			setBorderPainted(false);




			try {
				Image button = ImageIO.read(new File(path));
				setIcon(new ImageIcon(button));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public class Retour implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MainFrame.changePanel("MainScreenPanel") ;
		}


	}

	public class Import implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Open Resource File") ;

			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Images", "jpg", "jpeg", "png", "gif") ;
			fileChooser.setFileFilter(filter);
			int returnVal = fileChooser.showOpenDialog(null) ;

			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " +
						fileChooser.getSelectedFile().getName()) ;

				Path copy =Paths.get(fileChooser.getSelectedFile().getPath());
				Path paste = Paths.get("Images", fileChooser.getSelectedFile().getName());
				ImageGallery.add("Images/"+fileChooser.getSelectedFile().getName()) ;
				try {
					Files.copy(copy,paste) ;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


				displayImage() ;

				try {
					serialize(ImageGallery) ;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}


		}


	}
}







