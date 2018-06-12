/*
 * WeatherPanel.java
 * Auteur: Alexandre Schweizer
 * Date de création: 10 juin 2018
 */

package Meteo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import main.BasicPanel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class WeatherPanel extends BasicPanel {

	private JPanel weatherPanel = new JPanel() ;

	Color blueSky = new Color(135, 206, 250) ;

	private JLabel city ;

	private JLabel temperature ;

	private JLabel temperatureMin ;

	private JLabel temperatureMax ;

	private JLabel meteo ;

	public WeatherPanel() {

		weatherPanel.setBackground(blueSky) ;

		add(weatherPanel) ;

		weatherPanel.setLayout(new BorderLayout()) ;




		//URL contenant la clé d'API et l'id de la ville de Sierre

		String urlWeather = "http://api.openweathermap.org/data/2.5/weather?id=7287165&units=metric&APPID=6f5fe3ba8b1b33f969570ff3b5194913&lang=fr" ;

		OkHttpClient client = new OkHttpClient() ;

		Request request = new Request.Builder().url(urlWeather).build() ;

		Call call = client.newCall(request) ;

		call.enqueue(new Callback()  {

			@Override
			public void onFailure(Call call, IOException arg1) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Une erreur est survenue. Veuillez vérifier votre connexion Internet ou bien réessayer un peu plus tard", "Weather" , JOptionPane.ERROR_MESSAGE) ;			}

			@Override
			public void onResponse(Call call, Response resp) {
				// TODO Auto-generated method stub
				try(ResponseBody body = resp.body()) {
					//System.out.println(resp.code());
					if(resp.isSuccessful()) {

						String jsonData = body.string() ;
						JSONObject forecast = (JSONObject) JSONValue.parseWithException(jsonData) ;
						String name = (String) forecast.get("name") ;
						JSONObject main = (JSONObject) forecast.get("main") ;
						double temp = (double) main.get("temp") ;
						String currentTemp = String.valueOf(temp) ;
						long min = (long) main.get("temp_min") ;
						String minTemp = String.valueOf(min) ;
						long max = (long) main.get("temp_max") ;
						String maxTemp = String.valueOf(max) ;
						JSONArray info = (JSONArray) forecast.get("weather") ;

						String infoMeteo = info.toJSONString() ;
						String retourInfo = "" ;

						for (int i = 0; i <infoMeteo.length(); i++) {
							if(infoMeteo.charAt(i)==infoMeteo.charAt(2)) ;
							else
								retourInfo=retourInfo+infoMeteo.charAt(i) ;
						}

						int j =23 ;

						String description = "" ;

						do {

							description = description+retourInfo.charAt(j) ;
							j++ ;

						} while (retourInfo.charAt(j)!=',') ;

						//						System.out.println(description) ;
						//						System.out.println(name) ;
						//						System.out.println(temp) ;
						//						System.out.println(min) ;
						//						System.out.println(max) ;
						//						System.out.println(info) ;


						city = new JLabel(name) ;
						weatherPanel.add(city,BorderLayout.PAGE_START) ;
						city.setHorizontalAlignment(SwingConstants.CENTER) ;
						city.setFont(new Font("Helvetica Neue",  Font.BOLD, 34)) ;
						city.setForeground(new Color(51, 153, 255)) ;
						city.setPreferredSize(new Dimension(270, 135)) ;

						temperatureMin = new JLabel("Min: " + minTemp + "°C") ;
						weatherPanel.add(temperatureMin, BorderLayout.LINE_START) ;
						temperatureMin.setHorizontalAlignment(SwingConstants.CENTER) ;
						temperatureMin.setFont(new Font("Helvetica Neue",  Font.BOLD, 12)) ;
						temperatureMin.setForeground(new Color(0, 0, 204)) ;
						temperatureMin.setPreferredSize(new Dimension(67, 270));

						temperature = new JLabel(currentTemp + "°C") ;
						weatherPanel.add(temperature, BorderLayout.CENTER);
						temperature.setHorizontalAlignment(SwingConstants.CENTER) ;
						temperature.setFont(new Font("Helvetica Neue", Font.BOLD, 30)) ;
						temperature.setForeground(Color.WHITE) ;
						temperature.setPreferredSize(new Dimension(135, 270)) ;

						temperatureMax = new JLabel("Max: " + maxTemp + "°C") ;
						weatherPanel.add(temperatureMax, BorderLayout.LINE_END) ;
						temperatureMax.setHorizontalAlignment(SwingConstants.CENTER) ;
						temperatureMax.setFont(new Font("Helvetica Neue", Font.BOLD, 12)) ;
						temperatureMax.setForeground(new Color(0, 0, 204)) ;
						temperatureMax.setPreferredSize(new Dimension(67, 270)) ;

						meteo = new JLabel(description) ;
						weatherPanel.add(meteo, BorderLayout.PAGE_END) ;
						meteo.setHorizontalAlignment(SwingConstants.CENTER) ;
						meteo.setFont(new Font("Helvetica Neue", Font.BOLD, 22)) ;
						meteo.setForeground(Color.WHITE) ;
						meteo.setPreferredSize(new Dimension(270, 135)) ;

						File dossier = new File("ReadAndWrite") ;
						dossier.mkdirs() ;

						File fichier = new File(dossier, "Meteo.txt") ;


						try {
							fichier.createNewFile() ;

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace() ;
						}

						FileWriter fwrite ;

						try {

							fwrite = new FileWriter(fichier) ;
							BufferedWriter bfwrite = new BufferedWriter(fwrite) ;
							bfwrite.write(infoMeteo) ;
							bfwrite.close() ;

							FileReader fread = new FileReader(fichier) ;
							BufferedReader bfread = new BufferedReader(fread) ;
							System.out.println("Voici la météo du moment au format JSon" + bfread.readLine()) ;

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace() ;
						}


					}

					else {
						JOptionPane.showMessageDialog(null, "Une erreur est survenue", "Weather" , JOptionPane.ERROR_MESSAGE) ;

					}

				} catch (ParseException | IOException e) {
					JOptionPane.showMessageDialog(null, "Une erreur est survenue", "Weather" , JOptionPane.ERROR_MESSAGE) ;

				}



			}
		})
		;
	}
}




