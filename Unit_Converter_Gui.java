package unit_converter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Unit_Converter_Gui {
    private JFrame frame;
    private JLabel inputLabel,outputLabel;
    private JTextField input;
    private JTextField output;
    private JComboBox<String> fromUnit;
    private JComboBox<String> toUnit;
    private JButton button;
    public void initComponent(){
        frame=new JFrame("Unit Converter");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        inputLabel=new JLabel("INPUT: ");
        input=new JTextField(10);
        outputLabel=new JLabel("OUTPUT :");
        output=new JTextField(10);
        output.setEditable(false);
        button=new JButton("CONVERT");
        fromUnit=new JComboBox<String>(new String[]{"Meter","Feet","Centimeter","Kilometer","leter","miligran","gram","foot"});
        toUnit=new JComboBox<String>(new String[]{"Meter","Feet","Centimeter","Kilometer","leter","miligram","gram","foot"});


        inputLabel.setBounds(20,50,100,20);
        input.setBounds(150,50,100,20);
        fromUnit.setBounds(270,50,100,20);
        outputLabel.setBounds(20,80,100,20);
        output.setBounds(150,80,100,20);
        toUnit.setBounds(270,80,100,20);
        button.setBounds(150,120,100,20);

        button.addActionListener(new ConverterButtonListener());


        frame.add(inputLabel);
        frame.add(input);
        frame.add(fromUnit);
        frame.add(outputLabel);
        frame.add(output);
        frame.add(toUnit);
        //frame.add(toUnit);
        frame.add(button);
    }
    private class ConverterButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           String fromunittype=fromUnit.getSelectedItem().toString();
           String tounittype=toUnit.getSelectedItem().toString();
           double inputValue=Double.parseDouble(input.getText());
           double outputValue=0.0;
           if(fromunittype.equals("Meter")){
               if(tounittype.equals("Meter")){
                   outputValue=inputValue;
                 //  output.setText(""+outputValue);
               }
               else{
                   if(tounittype.equals("Centimeter"))
                       outputValue=inputValue*100;
                   else{
                       if(tounittype.equals("Feet"))
                           outputValue=inputValue*3.28084;
                       else{
                           if(tounittype.equals("Kilometer"))
                               outputValue=inputValue*0.001;
                       }
                   }
               }
               output.setText(""+outputValue);
           }
           else{
               if(fromunittype.equals("Feet")){
                   if(tounittype.equals("Meter"))
                       outputValue=inputValue*0.305;
                   else{
                       if(tounittype.equals("Feet"))
                           outputValue=inputValue;
                       else{
                           if(tounittype.equals("Centimeter"))
                               outputValue=inputValue*30.48;
                           else{
                               if(tounittype.equals("Kilometer"))
                                   outputValue=inputValue*0.000305;
                           }
                       }
                   }
                 output.setText(""+outputValue);
               }
               else{
                   if(fromunittype.equals("Centimeter")){
                       if(tounittype.equals("Centimeter"))
                           outputValue=inputValue;
                       else{
                           if(tounittype.equals("Meter"))
                               outputValue=inputValue*0.01;
                           else{
                               if(tounittype.equals("Feet"))
                                   outputValue=inputValue*0.0328084;
                               else{
                                   if(tounittype.equals("Kilomter"))
                                       outputValue=inputValue*0.000001;
                               }
                           }
                       }
                 output.setText(""+outputValue);
                   }
                   else{
                       if(fromunittype.equals("Kilometer")){
                           if(tounittype.equals("Kilometer"))
                               outputValue=inputValue;
                           else{
                               if(tounittype.equals("Meter"))
                                   outputValue=inputValue*1000;
                               else{
                                   if(tounittype.equals("Centimeter"))
                                       outputValue=inputValue*100000;
                                   else{
                                       if(tounittype.equals("Feet"))
                                           outputValue=inputValue*3280.84;
                                   }
                               }
                           }
                       }
                       output.setText(""+outputValue);
                   }
               }
           }
        }
    }
    public Unit_Converter_Gui(){
        initComponent();
    }
}
