package com.acilia.ttschool.utils;

import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.constant.ViewConstant;

@Component("logutils")
public class LogUtils {


	public static String getNombreMetodo() {
		// Retorna el nombre del metodo desde el cual se hace el llamado
		return new Exception().getStackTrace()[1].getMethodName();
	}

	public  void inMetodo(Log LOG, String nombreMetodo, Hashtable<String, String> params) {
		StringBuilder stb = new StringBuilder();
		try {
			stb.append("IN METHOD: " + nombreMetodo);

			if (params!=null && params.size() > 0) {
				String key;
				stb.append(" -- PARARMS:");
				Enumeration<String> keys = params.keys();
				while (keys.hasMoreElements()) {
					key = (String) keys.nextElement();
					stb.append(" " + key + "= ");
					stb.append(params.get(key));

				}

			}

		} catch (Exception e) {

		}
		LOG.info(stb.toString());

	}
	
	public  void outMetodo(Log LOG, String nombreMetodo, String view) {
		//LOG.info("Returning to "+ ViewConstant.LOGIN_VIEW +" view");
		StringBuilder stb = new StringBuilder();
		try {
			stb.append("OUT METHOD: " + nombreMetodo);
			if (view!=null) {
				stb.append(" " + view + " view");
			}
		} catch (Exception e) {
		}
		LOG.info(stb.toString());

	}
	


}
