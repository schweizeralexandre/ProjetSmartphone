package Contacts;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Gallery_Photos.GalleryPanel;
import main.BasicPanel;
import main.ButtonClass;

public class ContactPicturePanel extends BasicPanel{
	
	GalleryPanel gallerypan;
	ArrayList<String> images =  new ArrayList<>();
	ArrayList<ButtonClass> photo;
    JPanel picpanel = new BasicPanel();
    //protected int j;
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
		   //photo.get(i).addActionListener(new ContactpictureListner());
		   
		   int j = i;
		   
		   photo.get(i).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			/*	System.out.println(images.get(j));
				pan.getPerson().get(modify.id).setImage(images.get(j));
				modify.addimage.setIcon(photo.get(j).getIcon());
				//photo.get(j);
				System.out.println(pan.getPerson().get(j));
				ImageIcon img = new ImageIcon(pan.getPerson().get(j).getImage());
			
				
	            pan.contactview.contactImage.setIcon(img);
	           // pan.contactview.contactImage.getIcon()(img);
				System.out.println("xxxxx");*/
				
				modify.addimage.setIcon(photo.get(j).getIcon());
			    pan.getPerson().get(modify.id).setImage(images.get(j));
			    
			
                ImageIcon img = new ImageIcon(pan.getPerson().get(modify.id).getImage());
                System.out.println(pan.contactview);
                System.out.println(pan.contactview.contactImage);
	            pan.contactview.contactImage.setIcon(img);
			    
			    
			    
			    
			    System.out.println(images.get(j));
				System.out.println("yyooooo");
				
				
				
				pan.cards.show(pan, "contactmodify");
			}
		});
		}
		
		//images = this.deserialize();
		
		
		this.add(picpanel);
		
		
		
	}
	

	
	

}
