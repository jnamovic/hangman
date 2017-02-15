import java.awt.Color;

import acm.graphics.GCompound;

public class ABetterGallows extends GCompound implements ProgressivelyDrawable  {
	

		/** Make the graphics for a hangman.
		 * @param wid  the width of the allocated area for the hangman graphics
		 * @param ht   the height of the allocated area for the hangman graphics
		 */
		public ABetterGallows(double wid, double ht) {
			super();
			width = wid;
			height = ht;
//			if (width / height < WIDTH_TO_HEIGHT_RATIO)
//				height = width / WIDTH_TO_HEIGHT_RATIO;
//			else if (width / height > WIDTH_TO_HEIGHT_RATIO)
//				width = height * WIDTH_TO_HEIGHT_RATIO;
		}
		
		public void drawNextPart() {
			drawPart(part++);
		}
		
		/**
		 * Draw a particular part of a hangman object.
		 * @param part  the part number
		 */
		private void drawPart(int part) {
//			switch (part) {
//				case 0: addGallows(); break;
//				case 1: addFace(); break;
//				case 2: addBody(); break;
//				case 3: addLeftArm(); break;
//				case 4: addRightArm(); break;
//				case 5: addLeftLeg(); break;	
//				case 6: addRightLeg(); break;			
//			}
		}
		private static final int MAX_PARTS = 6;
		private static final Color  GALLOWS_COLOR = Color.BLACK;
		private static final Color  HANGMAN_COLOR = Color.YELLOW;
		
		private double width, height;
		private int part;
@Override
public void reset() {
	// TODO Auto-generated method stub
	
}

@Override
public int getMaxParts() {
	// TODO Auto-generated method stub
	return 0;
}
}
