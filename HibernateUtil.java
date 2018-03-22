package br.com.farmacia.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	private static SessionFactory criarFabricaDeSessoes() {
		try {
			// Cria uma SessionFactory a partir do hibernate.cfg.xml
			Configuration configuracao = new Configuration().configure();

			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();

			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			return fabrica;

		} catch (Throwable ex) {
			// Exibe uma menssagem de erro
			System.err.println("Falha ao tentar criar a Fábrica de Sessões." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
