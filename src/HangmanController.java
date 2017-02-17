import java.awt.Color;

import acm.program.GraphicsProgram;

public class HangmanController extends GraphicsProgram {


		int totalwins=0,totallosses=0;
		/**
		 * Makes view and model
		 */
		HangmanView view;
		HangmanModel model;
		private static final Color behind = new Color(67,175,170);

		public static void main(String[] args) {
			(new HangmanController()).start();
		}
/*{{{{{P4U1}}}}}*/

		/** Initialize the view and model. */
		public void init () {
			setSize(800,600);
			setBackground(behind);
			view = new HangmanView(this);
			model = new HangmanModel(view);
			
		}
	}


