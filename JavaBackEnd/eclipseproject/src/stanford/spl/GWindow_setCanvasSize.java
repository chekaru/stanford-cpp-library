package stanford.spl;

import java.awt.Dimension;

import acm.util.TokenScanner;

class GWindow_setCanvasSize extends JBECommand {
	public void execute(TokenScanner paramTokenScanner, JavaBackEnd paramJavaBackEnd) {
		paramTokenScanner.verifyToken("(");
		String str1 = nextString(paramTokenScanner);
		JBEWindow localJBEWindow = paramJavaBackEnd.getWindow(str1);
		paramTokenScanner.verifyToken(",");
		int w = nextInt(paramTokenScanner);
		paramTokenScanner.verifyToken(",");
		int h = nextInt(paramTokenScanner);
		paramTokenScanner.verifyToken(")");
		if (localJBEWindow != null) {
			localJBEWindow.getCanvas().setPreferredSize(new Dimension(w, h));
			localJBEWindow.getCanvas().validate();
			localJBEWindow.validate();
			if (localJBEWindow.isShowing()) {
				// localJBEWindow.getCanvas().setSize(new Dimension(w, h));
				localJBEWindow.pack();
			}
		}
	}
}
