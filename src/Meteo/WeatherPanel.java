/*
 * WeatherPanel.java
 * Auteur: Alexandre Schweizer
 * Date de création: 10 juin 2018
 */

package Meteo;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.BasicPanel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherPanel extends BasicPanel {

	private JPanel weatherPanel = new JPanel() ;

	Color blueSky = new Color(135, 206, 250) ;

	public WeatherPanel() {

		System.out.println("coucou");

		weatherPanel.setBackground(blueSky) ;

		add(weatherPanel) ;

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
			public void onResponse(Call call, Response resp) throws IOException {
				// TODO Auto-generated method stub
				System.out.println(resp.code());
				if(resp.isSuccessful()) {
					System.out.println(resp.body().string());
				} else {
					JOptionPane.showMessageDialog(null, "Une erreur est survenue", "Weather" , JOptionPane.ERROR_MESSAGE) ;

				}

			}


		});
	}


}
