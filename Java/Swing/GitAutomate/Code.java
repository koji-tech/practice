import javax.swing.*;
// import javax.swing.JButton;
// import javax.swing.JFileChooser;
// import javax.swing.JFrame;
// import javax.swing.JMenu;
// import javax.swing.JMenuBar;
// import javax.swing.JMenuItem;

import java.io.File;
import java.awt.event.*;
import java.awt.*;

class Code{
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.visible();
    }
}
class MainFrame{
    // 全体で使用可能なフレーム生成
    private JFrame fm = new JFrame("My first");
    public MainFrame(){

        fm.setSize(400,500);
    
        //ウィンドウの最小サイズ指定。直後の新規ウィンドウにも影響する。
        fm.setMinimumSize(null);
        // ウィンドウの閉じる=プログラム全体の強制終了
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // メニューバーの追加.画面上部にある|File|Edit|Help|
        JMenuBar menuBar = new JMenuBar();
            JMenu menuFile = new JMenu("File");
            JMenu menuEdit = new JMenu("Edit");
            JMenu menuHelp = new JMenu("Help");
            menuBar.add(menuFile);
            menuBar.add(menuEdit);
            menuBar.add(menuHelp);
            JMenuItem menuFileNew = new JMenuItem("新規");
            JMenuItem menuFileOpen = new JMenuItem("開く");
            menuFile.add(menuFileNew);
            menuFile.add(menuFileOpen);
            fm.setJMenuBar(menuBar);

        // ボタン生成,プロパティ
        JButton buttonHomeDirOpen = new JButton("Home dir (C:/)");
        JButton buttonSelectedDirOpen = new JButton("Select Root Directory");
        // buttonSelectedDirOpen.setFont(new Font("Arial", Font.BOLD, 16));
        // buttonSelectedDirOpen.setBounds(50, 50, 200, 30); // (x座標, y座標, 幅, 高さ)
        // fm.setLayout(null);  // 🔹 レイアウトを手動配置に変更
        // buttonSelectedDirOpen.setBackground(Color.BLACK);
        // buttonSelectedDirOpen.setForeground(Color.WHITE);
        // buttonSelectedDirOpen.setFocusPainted(false);
    
        
        // フォルダリスト doubleclick -> cd command
        DefaultListModel<String> folderModel = new DefaultListModel<>();  
        JList<String> folderJList = new JList<>(folderModel);
        folderModel.addElement("hoge");
        
        // ファイルリスト doubleclick -> addElement("File name"), List.add("File Path")
        DefaultListModel<String> fileModel = new DefaultListModel<>();
        JList<String> fileList = new JList<>(fileModel);
        fileModel.addElement("moge");
        
        JPanel topPanel = new JPanel();
        topPanel.add(buttonHomeDirOpen);
        topPanel.add(buttonSelectedDirOpen);
        
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(4,1));
        midPanel.add(new JLabel("フォルダを開く"));
        midPanel.add(new JScrollPane(folderJList));
        midPanel.add(new JLabel("ファイルの選択"));
        midPanel.add(new JScrollPane(fileList));
        
        fm.add(topPanel, BorderLayout.NORTH);
        fm.add(midPanel, BorderLayout.CENTER);
        // fm.add(new JScrollPane(folderJList));
        // fm.add(new JScrollPane(fileList));

        // Event

        // ボタンへのイベント設定
        buttonHomeDirOpen.addActionListener(e -> homeFolderList(folderModel));
        buttonSelectedDirOpen.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String dir = getFolderPathString();
                System.out.println(dir);
            }
        });
    }//MainFrame END

    public String getFolderPathString(){
        // フォルダ選択ダイアログの作成
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // フォルダのみ選択

        // ダイアログの表示
        int returnValue = fileChooser.showOpenDialog(null);
        File selectedFolder = fileChooser.getSelectedFile();

        // ユーザーがフォルダを選択した場合
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println("選択されたフォルダのパス: " + selectedFolder.getAbsolutePath());
        }
        return (returnValue == JFileChooser.APPROVE_OPTION) ? selectedFolder.getAbsolutePath() : "Don't selected";
    }

    public void homeFolderList(DefaultListModel<String> model){
        // default folder
        String directoryPath = "C:/";
        // ディレクトリのオブジェクトを作成
        File dir = new File(directoryPath);

        // リストの初期化
        model.clear();
        model.addElement("../");
        // ディレクトリの存在を確認
        if (dir.exists() && dir.isDirectory()) {
            // ディレクトリ内のファイル一覧を取得
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if(file.isDirectory()){
                        model.addElement(file.toString());
                    }
                }
            }
        } else {
            System.out.println("指定されたディレクトリが存在しません。");
        }
    }

    private void fileInFolderList(String path){

    }
    public void visible(){
        fm.setVisible(true);
    }

}