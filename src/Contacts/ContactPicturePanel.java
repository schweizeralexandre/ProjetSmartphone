package Contacts;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Gallery_Photos.GalleryPanel;
import main.BasicPanel;
import main.ButtonClass;

/**
 * classe qui permet d'afficher les images de la gallerypanel pour en choisir pour les contacts
 * @author ashan
 *
 */

public class ContactPicturePanel extends BasicPanel{
	
	private GalleryPanel gallerypan;
	private ArrayList<String> images =  new ArrayList<>();
	private ArrayList<ButtonClass> photo;
    private JPanel picpanel = new BasicPanel();
	private ContactModify modify;
	private ContactPanel pan;
	
	public ContactPicturePanel(ContactModify modify, ContactPanel pan){
		

		
		this.modify = modify;
		this.pan = pan;
		gallerypan = new GalleryPanel();
		
		images = gallerypan.getImageGallery();
		photo = new ArrayList<>();
		picpanel.setLayout(new FlowLayout());
		
		for (int i = 0; i < images.size(); i++) {
			
		   photo.add(new ButtonClass(images.get(i)));
		   picpanel.add(photo.get(i));
		   photo.get(i).setPreferredSize(new Dimension(120, 100));
		 
		   int j = i;
		   
		   photo.get(i).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					modify.addimage.setIcon(photo.get(j).getIcon());
				    pan.getPerson().get(modify.id).setImage(images.get(j));
				    ImageIcon img = new ImageIcon(pan.getPerson().get(modify.id).getImage());
				    pan.contactview.contactImage.setIcon(img);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			
//              
			    
			    
			    
	            System.out.println("modify id "+modify.id);
			    System.out.println(images.get(j));
				System.out.println("yyooooo");
				
				
				
				pan.cards.show(pan, "contactmodify");
			}
		});
		}
		
		
		for (int i = 0; i < photo.size(); i++) {
			
			try {
		         ImageIcon img = new ImageIcon(images.get(i));
		         Image picture  = getImageIcon(img.getImage(), 270, 250);
		         photo.get(i).setIcon(new ImageIcon(picture)) ;
		      
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		}
		
		
		
		
		
		this.add(picpanel);
		
		
		
	}
	
	/**
	 * méthode qui permet de rédimensionner les images sur le contactpicturepanel
	 * @param img
	 * @param x
	 * @param y
	 * @return
	 */
	
	
	
	private Image getImageIcon (Image img, int x, int y) {
		BufferedImage resizedImg = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB) ;
		Graphics2D g2 = resizedImg.createGraphics() ;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR) ;
		g2.drawImage(img, 0, 0,x, y, null) ;
		g2.dispose() ;
		return resizedImg ;
	}

	

	
	

}
