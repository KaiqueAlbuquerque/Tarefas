package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.Conjunto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonFacade {

	public static StringBuilder montaJSon(HttpServletRequest request) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static String listToJSon(ArrayList<Conjunto> lista) {
		JSONArray vetor = new JSONArray();
		for (Conjunto to : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("andar", to.getAndar());
				object.put("salas", to.getSalas());
				object.put("tamanho", to.getTamanho());
				object.put("valor", to.getValor());
				object.put("observacao", to.getObservacao());
				object.put("situacao", to.getSituacao());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}

	public static Conjunto jSonToConjunto(String json) throws IOException {
		try {
			JSONObject registro = new JSONObject(json);
			int salas = registro.getInt("salas");
			double tamanho = registro.getDouble("tamanho");
			double valor = registro.getDouble("valor");
			String observacao = registro.getString("observacao");
			int situacao = registro.getInt("situacao");

			Conjunto conjunto = new Conjunto();
			conjunto.setSalas(salas);
			conjunto.setTamanho(tamanho);
			conjunto.setValor(valor);
			conjunto.setObservacao(observacao);
			conjunto.setSituacao(situacao);
			return conjunto;
		} catch (JSONException jsone) {
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}

	public static String ConjuntoToJSon(Conjunto to) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("andar", to.getAndar());
			object.put("salas", to.getSalas());
			object.put("tamanho", to.getTamanho());
			object.put("valor", to.getValor());
			object.put("observacao", to.getObservacao());
			object.put("situacao", to.getSituacao());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
