package executors;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.ServiceLoader;

import plugins.FormulaPlugin;

public class PluginExecution {

	public static void main(final String args[]) throws IOException {

		// File loc = new File("./resources/plugins");
		// // extendClasspath(loc);
		// File[] flist = loc.listFiles(new FileFilter() {
		// @Override
		// public boolean accept(final File file) {
		// return file.getPath().toLowerCase().endsWith(".jar");
		// }
		// });
		// URL[] urls = new URL[flist.length];
		// for (int i = 0; i < flist.length; i++) {
		// urls[i] = flist[i].toURI().toURL();
		// }
		// URLClassLoader ucl = new URLClassLoader(urls);

	}

	public static double getIdealPrice(final List<Double> prices) {

		double ip = 0.0;
		final ServiceLoader<FormulaPlugin> p = ServiceLoader.load(FormulaPlugin.class);

		for (FormulaPlugin formulaPlugin : p) {

			ip = formulaPlugin.calculateIdealPrice(prices);
		}
		return ip;
	}

	private static void extendClasspath(final File dir) throws IOException {
		URLClassLoader sysLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		URL urls[] = sysLoader.getURLs(), udir = dir.toURI().toURL();
		String udirs = udir.toString();
		for (URL url : urls) {
			if (url.toString().equalsIgnoreCase(udirs)) {
				System.out.println(url.toString());
				return;
			}
		}
		Class<URLClassLoader> sysClass = URLClassLoader.class;
		try {
			Method method = sysClass.getDeclaredMethod("addURL", new Class[] { URL.class });
			method.setAccessible(true);
			method.invoke(sysLoader, new Object[] { udir });
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
