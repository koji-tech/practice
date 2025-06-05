import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;



public class Code {
    private static JFrame fm = new JFrame("My first");
    public static void main(String[] args) {
        fm.setVisible(true);
        // fm.setTitle("yahoo");
        fm.setSize(400,320);

        //ウィンドウの最小サイズ指定。直後の新規ウィンドウにも影響する。
        fm.setMinimumSize(null);
        // プログラム全体の強制終了
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton popup = new JButton("create window");
        popup.setFont(new Font("Arial", Font.BOLD, 16));
        popup.setBounds(50, 50, 100, 20); // (x座標, y座標, 幅, 高さ)
        fm.setLayout(null);  // 🔹 レイアウトを手動配置に変更
        // popup.setBackground(Color.BLACK);
        // popup.setForeground(Color.WHITE);
        // popup.setFocusPainted(false);
        popup.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame newWindow = new JFrame("新規");
                newWindow.setSize(400,320);
                newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newWindow.setVisible(true);
            }
        });
        fm.add(popup);
    }
}
