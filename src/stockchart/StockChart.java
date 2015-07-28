package stockchart;

/**
 *
 * @author sheehantoufiq
 */

import java.awt.*;
import jpb.*;

public class StockChart {
    
    // Class variable
    private static Graphics g;
    
    private static final int userHeight = 500;
    private static final int userWidth = 500;
    
    private static final int chartHeight = userHeight + userHeight/10;
    private static final int chartWidth = userWidth;
    
    public static void main(String[] args) {
        
        // Prompt user for stock name
        SimpleIO.prompt("Enter Stock Name: ");
        String stockName = SimpleIO.readLine();
        
        // Prompt user for daily prices
        double monPrice = readDouble("Enter Monday's Price: ");
        double tuePrice = readDouble("Enter Tuesday's Price: ");
        double wedPrice = readDouble("Enter Wednesday's Price: ");
        double thuPrice = readDouble("Enter Thursday's Price: ");
        double friPrice = readDouble("Enter Friday's Price: ");
                
        int monbarHeight = (chartHeight - chartHeight/10) / 2;
        int monbarX = 0;
        int monbarY = (chartHeight - chartHeight/10) / 2;
        int montextX = (chartWidth/5) / 4;

        int tuebarHeight = (chartHeight - chartHeight/10) / 2;
        int tuebarX = chartWidth - ((chartWidth/5) * 4);
        int tuebarY = (chartHeight - chartHeight/10) / 2;
        int tuetextX = ((chartWidth/5) / 4) + ((chartWidth/5) * 1);
        
        int wedbarHeight = (chartHeight - chartHeight/10) / 2;
        int wedbarX = chartWidth - ((chartWidth/5) * 3);
        int wedbarY = (chartHeight - chartHeight/10) / 2;
        int wedtextX = ((chartWidth/5) / 4) + ((chartWidth/5) * 2);
        
        int thubarHeight = (chartHeight - chartHeight/10) / 2;
        int thubarX = chartWidth - ((chartWidth/5) * 2);
        int thubarY = (chartHeight - chartHeight/10) / 2;
        int thutextX = ((chartWidth/5) / 4) + ((chartWidth/5) * 3);
        
        int fribarHeight = (chartHeight - chartHeight/10) / 2;
        int fribarX = chartWidth - ((chartWidth/5) * 1);
        int fribarY = (chartHeight - chartHeight/10) / 2;
        int fritextX = ((chartWidth/5) / 4) + ((chartWidth/5) * 4);
        
        // Create drawable frame
        DrawableFrame df = new DrawableFrame("Chart for " + stockName);
        df.show();
        df.setSize(chartWidth, chartHeight); 
        
        g = df.getGraphicsContext();
        
        // Draw Bar Graphs
        drawBar(Color.red, monbarX, monbarY, monbarHeight);
        drawBar(Color.blue, tuebarX, tuebarY, tuebarHeight);
        drawBar(Color.green, wedbarX, wedbarY, wedbarHeight);
        drawBar(Color.magenta, thubarX, thubarY, thubarHeight);
        drawBar(Color.cyan, fribarX, fribarY, fribarHeight);
        
        // Draw Weekday Labels
        drawText("Mon", montextX);
        drawText("Tue", tuetextX);        
        drawText("Wed", wedtextX);
        drawText("Thu", thutextX);
        drawText("Fri", fritextX);
        
        // Draw Prices
        drawNum(monPrice, montextX);
        drawNum(tuePrice, tuetextX);        
        drawNum(wedPrice, wedtextX);
        drawNum(thuPrice, thutextX);
        drawNum(friPrice, fritextX);
        
        // Paint Frame
        df.repaint();

    }
    
    private static double readDouble(String prompt) {
        SimpleIO.prompt(prompt);
        String userInput = SimpleIO.readLine();
        return Convert.toDouble(userInput);
    }
    
    private static void drawText(String day, int textX) {
        
        int textY = (chartHeight-chartHeight/10) + (chartHeight/20);
        
        g.setColor(Color.black);
        g.setFont(new Font("SanSerif", Font.PLAIN, chartWidth/20));
        g.drawString(day, textX, textY);
    }
    
    private static void drawNum(double num, int numX) {
        
        int numY = 220;
        
        g.setColor(Color.black);
        g.setFont(new Font("SanSerif", Font.PLAIN, chartWidth/20));
        
        String price = String.valueOf(num);
        g.drawString(price, numX, numY);
    }
    
    private static void drawBar(Color c, int barX, int barY, int barHeight) {
        
        int barWidth = chartWidth / 5;
        
        g.setColor(c);
        g.fillRect(barX, barY, barWidth, barHeight);
    }
}
