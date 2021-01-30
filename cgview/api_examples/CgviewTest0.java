import ca.ualberta.stothard.cgview.*;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.batik.ext.awt.image.codec.PNGEncodeParam.Gray;

public class CgviewTest0 implements CgviewConstants {

	public static void main(String args[]) throws FileNotFoundException {

		int length = 2800;
		Cgview cgview = new Cgview(length);

		// some optional settings
		cgview.setWidth(600);
		cgview.setHeight(600);
		cgview.setBackboneRadius(140.0f);
		cgview.setTitle("Tomato curly stunt virus");
		cgview.setLabelPlacementQuality(10);
		cgview.setShowWarning(true);
		cgview.setLabelLineLength(8.0d);
		cgview.setLabelLineThickness(0.5f);
		//cgview.setShowBorder(true);
		cgview.setArrowheadLength(7.5);
		//cgview.setFeatureThickness(10.5f);
		cgview.setFeatureSlotSpacing(0.1);
		// create a FeatureSlot to hold sequence features
		FeatureSlot featureSlot = new FeatureSlot(cgview, DIRECT_STRAND);
		FeatureSlot featureSlot1 = new FeatureSlot(cgview, REVERSE_STRAND);
		featureSlot.setFeatureThickness(30.0f);
		featureSlot1.setFeatureThickness(30.0f);
		File file = new File("genome.gb");
		Scanner sc = new Scanner(file);
		Color x = Color.BLUE;
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			//System.out.println("here is the str : "+str);
			ArrayList<String> myList = ltrim(str);
			/*for (String temp : myList)
			{
				System.out.println("items " + temp);
			}*/
			if (myList.get(0).compareTo("CDS") == 0)
			{
				//System.out.println(myList.get(0));
				//This is the strart and end
				ArrayList<Integer> listInt = itrim(myList.get(1));
				int start = listInt.get(0);
				int end = listInt.get(1);

				//Let get its label
				str = ltrim(sc.nextLine()).get(0);
				String label = "";
				for (int i = 7 ; i < str.length() ; i++)
				{
					if (str.charAt(i) == '"')
					{
						break;
					}
					label += str.charAt(i);
				}

				if (myList.get(1).charAt(0) < '0' || myList.get(1).charAt(0) > '9')
				{
					//System.out.println("start : "+start + " end : " + end);
					paint(featureSlot1 , label , start , end , 1 , new Color(0f,0f,1f,.5f ));
					//x = x.brighter().brighter();
				}
				else
				{
					//System.out.println("start : "+start + " end : " + end);
					if (end <= 480)
					paint(featureSlot , label , start , end , 0 , new Color(0f,0f,1f,.5f ));
					else
					paint(featureSlot , label , start , end , 0 , new Color(0f,0f,1f,.5f ));
					//x = x.brighter().brighter();
				}

			}
		}
		// create random sequence features
		/*for (int i = 1; i <= 5; i++) {

			int j = Math.round((float) ((float) (length - 2) * Math.random())) + 1;
			// int j = 1;
			// a Feature to add to our FeatureSlot

			// a single FeatureRange to add the Feature
			if (i % 2 == 1) {
				Feature feature = new Feature(featureSlot, "one");
				feature.setShowShading(true);
				FeatureRange featureRange = new FeatureRange(feature, j, j + 500);
				featureRange.setShowShading(true);
				featureRange.setColor(Color.gray);
				featureRange.setDecoration(DECORATION_COUNTERCLOCKWISE_ARROW);
				// featureRange.setDecoration(SWATCH_SHOW);
			} else {
				Feature feature1 = new Feature(featureSlot1, "in");
				feature1.setShowShading(true);
				FeatureRange featureRange1 = new FeatureRange(feature1, j, j + 500);
				featureRange1.setShowShading(true);
				featureRange1.setColor(Color.gray);
				featureRange1.setDecoration(DECORATION_CLOCKWISE_ARROW);
				// featureRange1.setDecoration(SWATCH_SHOW);
			}
		}*/

		try {
			// create a PNG file
			CgviewIO.writeToPNGFile(cgview, "random_1.png");
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	private static void paint(FeatureSlot featureSlot , String label , int start , int end , int strand , Color x) {
		Feature feature = new Feature(featureSlot, label);
		FeatureRange featureRange = new FeatureRange(feature, start , end);
		featureRange.setColor(x);
		if (strand == 1)
		{
			featureRange.setDecoration(DECORATION_COUNTERCLOCKWISE_ARROW);
		}
		else
		{
			featureRange.setDecoration(DECORATION_CLOCKWISE_ARROW);
		}
	}

	private static ArrayList<Integer> itrim(String str)
	{
		int cur = 0;
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for (int i = 0 ; i < str.length() ; i++)
		{
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
			{
				if (cur != 0)
				{
					myList.add(cur);
				}
				cur = 0;
				continue;
			}
			cur = cur * 10 + (str.charAt(i) - '0');
		}
		if (cur != 0)
		{
			myList.add(cur);
		}
		return myList;
	}

	private static ArrayList<String> ltrim(String str) {
		ArrayList<String> myList = new ArrayList<String>();
		String cur = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				if (cur != "") {
					myList.add(cur);
					cur = "";
				}
			} else {
				cur += str.charAt(i);
			}		
		}
		if (cur != "") {
			myList.add(cur);
			cur = "";
		}	
		return myList;
	}
}
