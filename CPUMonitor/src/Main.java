import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main extends JFrame implements ActionListener {
    /*Labels information about hardware
    /* Total number of processors or cores available to the JVM */
    JLabel jlAvProc = new JLabel("Available processors (cores): "+Runtime.getRuntime().availableProcessors());
    /* Total amount of free memory available to the JVM */
    JLabel jlFreeMemJVM = new JLabel("Free memory (bytes): "+Runtime.getRuntime().freeMemory());
    /* Maximum amount of memory the JVM will attempt to use */
    JLabel jlMaxMem = new JLabel("Maximum memory (bytes): "+Runtime.getRuntime().maxMemory());
    /* Total memory currently available to the JVM */
    JLabel jlCurAvMem = new JLabel("Total memory available to JVM (bytes): "+Runtime.getRuntime().totalMemory());
    static JLabel jlRootFileSys,jlTotalSpace,jlFreeSpa,jlUsaSpace;

    //Strings (key values)
    String nameOS = "os.name";
    String versionOS = "os.version";
    String architectureOS = "os.arch";

    /*Labels about O.S*/
    JLabel jlTitleInf = new JLabel("Information about your O.S");
    JLabel jlNameOS = new JLabel("Name of the OS: " + System.getProperty(nameOS));
    JLabel jlVersionOS = new JLabel("Version of the OS: " + System.getProperty(versionOS));
    JLabel jlArchOS = new JLabel("Architecture of The OS: " + System.getProperty(architectureOS));

    //JButton About
    JButton jbAbout = new JButton("About");

    public Main(){
        super("CPU Monitor");
        setSize(500,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        jlAvProc.setBounds(10,10,240,25);
        jlFreeMemJVM.setBounds(10,40,240,25);
        jlMaxMem.setBounds(10,70,300,25);
        jlCurAvMem.setBounds(10,100,350,25);
        jlRootFileSys.setBounds(10,130,300,25);
        jlTotalSpace.setBounds(10,160,300,25);
        jlFreeSpa.setBounds(10,190,300,25);
        jlUsaSpace.setBounds(10,220,300,25);
        jlTitleInf.setBounds(10,270,200,25);
        jlNameOS.setBounds(10,300,300,25);
        jlVersionOS.setBounds(10,330,300,25);
        jlArchOS.setBounds(10,360,300,25);
        jbAbout.setBounds(10,390,80,25);

        add(jlAvProc);
        add(jlFreeMemJVM);
        add(jlMaxMem);
        add(jlCurAvMem);
        add(jlRootFileSys);
        add(jlTotalSpace);
        add(jlFreeSpa);
        add(jlUsaSpace);
        add(jlTitleInf);
        add(jlNameOS);
        add(jlVersionOS);
        add(jlArchOS);
        add(jbAbout);
        jbAbout.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(jbAbout == actionEvent.getSource()){
            JOptionPane.showMessageDialog(null,"Developed by: Gus");
        }
    }

    public static void main(String[] args) {
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            jlRootFileSys = new JLabel("File system root: " + root.getAbsolutePath());
            jlTotalSpace = new JLabel("Total space (bytes): " + root.getTotalSpace());
            jlFreeSpa = new JLabel("Free space (bytes): " + root.getFreeSpace());
            jlUsaSpace = new JLabel("Usable space (bytes): " + root.getUsableSpace());
        }
        new Main();
    }
}