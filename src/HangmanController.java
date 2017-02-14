import acm.program.GraphicsProgram;

public class HangmanController extends GraphicsProgram {


		
		HangmanView view;
		HangmanModel model;

		public static void main(String[] args) {
			(new HangmanController()).start();
		}
/*{{{{{P4U1}}}}}*/

		/** Initialize the view and model. */
		public void init () {
			view = new HangmanView(this);
			model = new HangmanModel(view);
			view.startUp(model, "fish");
			add(view);
		}
	}


