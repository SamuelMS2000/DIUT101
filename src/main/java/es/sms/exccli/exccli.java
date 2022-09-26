package es.sms.exccli;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.OptionGroup;

public class exccli {
     public static void main(String[] args) throws ParseException {
    
    // create Options object
Options options = new Options();
   
    options.addOption(new Option("h", false, " imprimir Ayuda.")); 
    options.addOption(new Option("w", false, " imprimir HolaMundo.")); 
    
    OptionGroup group =  new OptionGroup();
    group.addOption(new Option("n", "nice", false, " imprimir Bonito"));  
    group.addOption(new Option("c", "cruel", false,  " imprimir Cruel"));  
    group.addOption(new Option("y", "years", true,  " imprimir Years"));
    options.addOptionGroup(group);  
    
   try {  
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(options, args);   
   
    if (cmd.hasOption("h")){ 
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp ("time", options);
            }  

    else if(cmd.hasOption("w")) { System.out.print("Hola Mundo");
    if(cmd.hasOption("n")) System.out.print(" Bonito");
    else if(cmd.hasOption("c")) System.out.print(" Cruel");
    if(cmd.hasOption("y")){
        try{
            System.out.print (" tras " +Integer.parseInt( cmd.getOptionValue("y"))+ " años de vida");
        } catch (Exception e) { System.out.print("F");
            
    }
    }
    }
  } catch (org.apache.commons.cli.ParseException ex){  
            System.out.println(ex.getMessage()); 
     
     }
}
}
  
