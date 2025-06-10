

import com.sun.jdi.IntegerValue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.Expression;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;





public class Calculator {

    //Variáveis
        static Boolean typingNumbers = true;
        static Boolean programaAtivo = true;
        static Boolean showResult = false;
        static int numShownMaxLength = 14;
        static String numShown = "";
        static String conversor = "";
        static String result = "";
        static String lastOperation = "";
        static BigDecimal operations = new BigDecimal(0);
        

    public static void main(String[] args) throws Exception {

        

        //janela
        JFrame calculadoraSwing = new JFrame("Calculadora Java");
        calculadoraSwing.setSize(320, 495);
        calculadoraSwing.setResizable(false);
        calculadoraSwing.getContentPane().setBackground(Color.getHSBColor(0f,0f,0.1f));
        calculadoraSwing.setLayout(null);

        //botao 0
        JButton bNum0 = new JButton("0");
        bNum0.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum0.setBounds(8, 384, 140, 65);
        bNum0.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum0.setVerticalTextPosition(SwingConstants.CENTER);
        bNum0.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum0.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum0.setOpaque(true);
        bNum0.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum0.setFocusPainted(false);
        calculadoraSwing.add(bNum0);

        //botao ,
        JButton bNumV = new JButton(".");
        bNumV.setFont(new Font("Dialog", Font.BOLD, 34));
        bNumV.setBounds(158, 384, 65, 65);
        bNumV.setHorizontalTextPosition(SwingConstants.CENTER);
        bNumV.setVerticalTextPosition(SwingConstants.CENTER);
        bNumV.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNumV.setBackground(Color.getHSBColor(0f,0f,0.125f));
        bNumV.setOpaque(true);
        bNumV.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNumV.setFocusPainted(false);
        calculadoraSwing.add(bNumV);

        //botao =
        JButton bNumE = new JButton("=");
        bNumE.setFont(new Font("Dialog", Font.BOLD, 34));
        bNumE.setBounds(233, 384, 65, 65);
        bNumE.setHorizontalTextPosition(SwingConstants.CENTER);
        bNumE.setVerticalTextPosition(SwingConstants.CENTER);
        bNumE.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNumE.setBackground(Color.getHSBColor(0.55f, 0.75f, 0.45f));
        bNumE.setOpaque(true);
        bNumE.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNumE.setFocusPainted(false);
        calculadoraSwing.add(bNumE);

        //botao 1
        JButton bNum1 = new JButton("1");
        bNum1.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum1.setBounds(8, 309, 65, 65);
        bNum1.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum1.setVerticalTextPosition(SwingConstants.CENTER);
        bNum1.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum1.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum1.setOpaque(true);
        bNum1.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum1.setFocusPainted(false);
        calculadoraSwing.add(bNum1);

        //botao 2
        JButton bNum2 = new JButton("2");
        bNum2.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum2.setBounds(83, 309, 65, 65);
        bNum2.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum2.setVerticalTextPosition(SwingConstants.CENTER);
        bNum2.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum2.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum2.setOpaque(true);
        bNum2.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum2.setFocusPainted(false);
        calculadoraSwing.add(bNum2);

        //botao 3
        JButton bNum3 = new JButton("3");
        bNum3.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum3.setBounds(158, 309, 65, 65);
        bNum3.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum3.setVerticalTextPosition(SwingConstants.CENTER);
        bNum3.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum3.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum3.setOpaque(true);
        bNum3.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum3.setFocusPainted(false);
        calculadoraSwing.add(bNum3);

        //botao mais
        JButton bNumPlus = new JButton("+");
        bNumPlus.setFont(new Font("Dialog", Font.BOLD, 34));
        bNumPlus.setBounds(233, 309, 65, 65);
        bNumPlus.setHorizontalTextPosition(SwingConstants.CENTER);
        bNumPlus.setVerticalTextPosition(SwingConstants.CENTER);
        bNumPlus.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNumPlus.setBackground(Color.getHSBColor(0f,0f,0.125f));
        bNumPlus.setOpaque(true);
        bNumPlus.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNumPlus.setFocusPainted(false);
        calculadoraSwing.add(bNumPlus);

        //botao 4
        JButton bNum4 = new JButton("4");
        bNum4.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum4.setBounds(8, 234, 65, 65);
        bNum4.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum4.setVerticalTextPosition(SwingConstants.CENTER);
        bNum4.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum4.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum4.setOpaque(true);
        bNum4.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum4.setFocusPainted(false);
        calculadoraSwing.add(bNum4);

        //botao 5
        JButton bNum5 = new JButton("5");
        bNum5.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum5.setBounds(83, 234, 65, 65);
        bNum5.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum5.setVerticalTextPosition(SwingConstants.CENTER);
        bNum5.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum5.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum5.setOpaque(true);
        bNum5.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum5.setFocusPainted(false);
        calculadoraSwing.add(bNum5);

        //botao 6
        JButton bNum6 = new JButton("6");
        bNum6.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum6.setBounds(158, 234, 65, 65);
        bNum6.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum6.setVerticalTextPosition(SwingConstants.CENTER);
        bNum6.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum6.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum6.setOpaque(true);
        bNum6.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum6.setFocusPainted(false);
        calculadoraSwing.add(bNum6);

        //botao menos
        JButton bNumMinus = new JButton("-");
        bNumMinus.setFont(new Font("Dialog", Font.BOLD, 34));
        bNumMinus.setBounds(233, 234, 65, 65);
        bNumMinus.setHorizontalTextPosition(SwingConstants.CENTER);
        bNumMinus.setVerticalTextPosition(SwingConstants.CENTER);
        bNumMinus.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNumMinus.setBackground(Color.getHSBColor(0f,0f,0.125f));
        bNumMinus.setOpaque(true);
        bNumMinus.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNumMinus.setFocusPainted(false);
        calculadoraSwing.add(bNumMinus);

        //botao 7
        JButton bNum7 = new JButton("7");
        bNum7.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum7.setBounds(8, 159, 65, 65);
        bNum7.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum7.setVerticalTextPosition(SwingConstants.CENTER);
        bNum7.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum7.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum7.setOpaque(true);
        bNum7.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum7.setFocusPainted(false);
        calculadoraSwing.add(bNum7);

        //botao 8
        JButton bNum8 = new JButton("8");
        bNum8.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum8.setBounds(83, 159, 65, 65);
        bNum8.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum8.setVerticalTextPosition(SwingConstants.CENTER);
        bNum8.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum8.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum8.setOpaque(true);
        bNum8.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum8.setFocusPainted(false);
        calculadoraSwing.add(bNum8);

        //botao 9
        JButton bNum9 = new JButton("9");
        bNum9.setFont(new Font("Dialog", Font.BOLD, 34));
        bNum9.setBounds(158, 159, 65, 65);
        bNum9.setHorizontalTextPosition(SwingConstants.CENTER);
        bNum9.setVerticalTextPosition(SwingConstants.CENTER);
        bNum9.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNum9.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNum9.setOpaque(true);
        bNum9.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNum9.setFocusPainted(false);
        calculadoraSwing.add(bNum9);

        //botao vezes
        JButton bNumTimes = new JButton("×");
        bNumTimes.setFont(new Font("Dialog", Font.BOLD, 34));
        bNumTimes.setBounds(233, 159, 65, 65);
        bNumTimes.setHorizontalTextPosition(SwingConstants.CENTER);
        bNumTimes.setVerticalTextPosition(SwingConstants.CENTER);
        bNumTimes.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNumTimes.setBackground(Color.getHSBColor(0f,0f,0.125f));
        bNumTimes.setOpaque(true);
        bNumTimes.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNumTimes.setFocusPainted(false);
        calculadoraSwing.add(bNumTimes);

        //botao back
        JButton bNumBack = new JButton("⌫");
        bNumBack.setFont(new Font("Dialog", Font.BOLD, 24));
        bNumBack.setBounds(8, 84, 65, 65);
        bNumBack.setHorizontalTextPosition(SwingConstants.CENTER);
        bNumBack.setVerticalTextPosition(SwingConstants.CENTER);
        bNumBack.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNumBack.setBackground(Color.getHSBColor(0f,0f,0.125f));
        bNumBack.setOpaque(true);
        bNumBack.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNumBack.setFocusPainted(false);
        calculadoraSwing.add(bNumBack);

        //botao por
        JButton bNumPor = new JButton("%");
        bNumPor.setFont(new Font("Dialog", Font.BOLD, 34));
        bNumPor.setBounds(83, 84, 65, 65);
        bNumPor.setHorizontalTextPosition(SwingConstants.CENTER);
        bNumPor.setVerticalTextPosition(SwingConstants.CENTER);
        bNumPor.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNumPor.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNumPor.setOpaque(true);
        bNumPor.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNumPor.setFocusPainted(false);
        calculadoraSwing.add(bNumPor);

        //botao divisão
        JButton bNumDiv = new JButton("÷");
        bNumDiv.setFont(new Font("Dialog", Font.BOLD, 34));
        bNumDiv.setBounds(158, 84, 65, 65);
        bNumDiv.setHorizontalTextPosition(SwingConstants.CENTER);
        bNumDiv.setVerticalTextPosition(SwingConstants.CENTER);
        bNumDiv.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNumDiv.setBackground(Color.getHSBColor(0f,0f,0.15f));
        bNumDiv.setOpaque(true);
        bNumDiv.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNumDiv.setFocusPainted(false);
        calculadoraSwing.add(bNumDiv);

        //botao clear entry
        JButton bNumCE = new JButton("CE");
        bNumCE.setFont(new Font("Dialog", Font.BOLD, 24));
        bNumCE.setBounds(233, 84, 65, 65);
        bNumCE.setHorizontalTextPosition(SwingConstants.CENTER);
        bNumCE.setVerticalTextPosition(SwingConstants.CENTER);
        bNumCE.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.2f)));
        bNumCE.setBackground(Color.getHSBColor(0f,0f,0.125f));
        bNumCE.setOpaque(true);
        bNumCE.setForeground(Color.getHSBColor(0f,0f,0.9f));
        bNumCE.setFocusPainted(false);
        calculadoraSwing.add(bNumCE);

        //texto dos inputs da calculadora
        JLabel ResultsText = new JLabel("0  ");
        ResultsText.setFont(new Font("Dialog", Font.BOLD, 36));
        ResultsText.setBounds(8, 28, 290, 45);
        ResultsText.setHorizontalAlignment(SwingConstants.RIGHT);
        ResultsText.setVerticalTextPosition(SwingConstants.BOTTOM);
        ResultsText.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.15f)));
        ResultsText.setBackground(Color.getHSBColor(0f,0f,0.1f));
        ResultsText.setOpaque(true);
        ResultsText.setForeground(Color.getHSBColor(0f,0f,0.9f));
        calculadoraSwing.add(ResultsText);

        //texto ultima operação
        JLabel lastOperationText = new JLabel("");
        lastOperationText.setFont(new Font("Dialog", Font.BOLD, 12));
        lastOperationText.setBounds(8, 8, 290, 20);
        lastOperationText.setHorizontalAlignment(SwingConstants.CENTER);
        lastOperationText.setVerticalTextPosition(SwingConstants.TOP);
        lastOperationText.setBorder(new LineBorder(Color.getHSBColor(0f,0f,0.15f)));
        lastOperationText.setBackground(Color.getHSBColor(0f,0f,0.1f));
        lastOperationText.setOpaque(true);
        lastOperationText.setForeground(Color.getHSBColor(0f,0f,0.8f));
        calculadoraSwing.add(lastOperationText, Integer.valueOf(1));

        //faz a JFrame ser visível
        calculadoraSwing.setVisible(true);

        //keybindings para apertar botões
        //botão 0
        bNum0.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("0"), "tecla0");
        bNum0.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD0"), "tecla0");
        bNum0.getActionMap().put("tecla0", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum0.doClick(); }}});
        
        //botao V
        bNumV.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("typed ,"), "tecla,");
        bNumV.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("typed ."), "tecla,");
        bNumV.getActionMap().put("tecla,", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNumV.doClick(); }}});

        //botao =
        bNumE.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("EQUALS"), "tecla=");
        bNumE.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "tecla=");
        bNumE.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD_ENTER"), "tecla=");
        bNumE.getActionMap().put("tecla=", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNumE.doClick(); }}});

        //botao 1
        bNum1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("1"), "tecla1");
        bNum1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD1"), "tecla1");
        bNum1.getActionMap().put("tecla1", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum1.doClick(); }}});

        
        //botao 2
        bNum2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("2"), "tecla2");
        bNum2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD2"), "tecla2");
        bNum2.getActionMap().put("tecla2", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum2.doClick(); }}});

        //botao 3
        bNum3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("3"), "tecla3");
        bNum3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD3"), "tecla3");
        bNum3.getActionMap().put("tecla3", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum3.doClick(); }}});

        //botao +
        bNumPlus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift EQUALS"), "tecla+");
        bNumPlus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ADD"), "tecla+");
        bNumPlus.getActionMap().put("tecla+", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNumPlus.doClick(); }}});

        //botao 4
        bNum4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("4"), "tecla4");
        bNum4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD4"), "tecla4");
        bNum4.getActionMap().put("tecla4", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum4.doClick(); }}});

        //botao 5
        bNum5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("5"), "tecla5");
        bNum5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD5"), "tecla5");
        bNum5.getActionMap().put("tecla5", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum5.doClick(); }}});

        //botao 6
        bNum6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("6"), "tecla6");
        bNum6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD6"), "tecla6");
        bNum6.getActionMap().put("tecla6", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum6.doClick(); }}});

        //botao -
        bNumMinus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("MINUS"), "tecla-");
        bNumMinus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SUBTRACT"), "tecla-");
        bNumMinus.getActionMap().put("tecla-", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNumMinus.doClick(); }}});

        //botao 7
        bNum7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("7"), "tecla7");
        bNum7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD7"), "tecla7");
        bNum7.getActionMap().put("tecla7", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum7.doClick(); }}});

        //botao 8
        bNum8.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("8"), "tecla8");
        bNum8.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD8"), "tecla8");
        bNum8.getActionMap().put("tecla8", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum8.doClick(); }}});

        //botao 9
        bNum9.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("9"), "tecla9");
        bNum9.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD9"), "tecla9");
        bNum9.getActionMap().put("tecla9", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNum9.doClick(); }}});

        //botao x
        bNumTimes.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("typed *"), "tecla*");
        bNumTimes.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("*"), "tecla*");
        bNumTimes.getActionMap().put("tecla*", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNumTimes.doClick(); }}});

        //botao backspace
        bNumBack.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "teclaback");
        bNumBack.getActionMap().put("teclaback", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNumBack.doClick(); }}});

        //botao power
        bNumPor.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("typed %"), "teclap");
        bNumPor.getActionMap().put("teclap", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNumPor.doClick(); }}});

        //botao divisão
        bNumDiv.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("typed /"), "teclad");
        bNumDiv.getActionMap().put("teclad", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNumDiv.doClick(); }}});

        //botao clear entry
        bNumCE.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("typed c"), "teclace");
        bNumCE.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("typed C"), "teclace");
        bNumCE.getActionMap().put("teclace", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if (calculadoraSwing.isVisible() && calculadoraSwing.getExtendedState() != JFrame.ICONIFIED) {bNumCE.doClick(); }}});

        //action listeners

        //botão 0
        bNum0.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "0"; }}});

        //botão .
        bNumV.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() > 0 && numShown.length() < numShownMaxLength && numShown.charAt(numShown.length() - 1) != ' ' && numShown.charAt(numShown.length() - 1) != '.') {
                typingNumbers = false; numShown += ".";}}});

        //botão =
        bNumE.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {typingNumbers = false; showResult = true; }});

        //botão 1
        bNum1.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "1"; }}});

        //botão 2
        bNum2.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "2"; }}});

        //botão 3
        bNum3.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "3"; }}});

        //botão +
        bNumPlus.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() > 0 && numShown.length() < numShownMaxLength && numShown.charAt(numShown.length() - 1) != ' ' && numShown.charAt(numShown.length() - 1) != '.') {
                typingNumbers = false; numShown += " + "; }}});

        //botão 4
        bNum4.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "4"; }}});

        //botão 5
        bNum5.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "5"; }}});

        //botão 6
        bNum6.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "6"; }}});

        //botão -
        bNumMinus.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() > 0 && numShown.length() < numShownMaxLength && numShown.charAt(numShown.length() - 1) != ' ' && numShown.charAt(numShown.length() - 1) != '.') 
                {typingNumbers = false; numShown += " - "; }}});

        //botão 7
        bNum7.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "7"; }}});

        //botão 8
        bNum8.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "8"; }}});

        //botão 9
        bNum9.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() < numShownMaxLength) {typingNumbers = true; numShown += "9"; }}});

        //botão ×
        bNumTimes.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() > 0 && numShown.length() < numShownMaxLength && numShown.charAt(numShown.length() - 1) != ' ' && numShown.charAt(numShown.length() - 1) != '.') 
                {typingNumbers = false; numShown += " × "; }}});

        //botão back
        bNumBack.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() > 0) {
                    if ((numShown.charAt(numShown.length() -1)) == ' ') {numShown = numShown.substring(0, numShown.length() - 3);
                     } else { numShown = numShown.substring(0, numShown.length() - 1); }}}});

        //botão %
        bNumPor.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() > 0 && numShown.length() < numShownMaxLength && numShown.charAt(numShown.length() - 1) != ' ' && numShown.charAt(numShown.length() - 1) != '.') 
                {typingNumbers = false; numShown += " ÷ 100 "; showResult = true; }}});

        //botão ÷
        bNumDiv.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() > 0 && numShown.length() < numShownMaxLength && numShown.charAt(numShown.length() - 1) != ' ' && numShown.charAt(numShown.length() - 1) != '.') 
                {typingNumbers = false; numShown += " ÷ "; }}});
            
        //botão CE
        bNumCE.addActionListener(new ActionListener() { @Override 
            public void actionPerformed(ActionEvent e) {
                if (numShown.length() > 0) {lastOperationText.setText("");;numShown = numShown.substring(0, numShown.length() - numShown.length()); }}});

        //----------------------------------------------------backend calculadora-------------------------------------------------------

        //programa ativo
        try {
            while (programaAtivo) {
            ResultsText.setText(numShown + "");
            if (showResult) {
                conversor = numShown;
                conversor = conversor.replace("×", "*");
                conversor = conversor.replace('÷', '/');
                net.objecthunter.exp4j.Expression e = new net.objecthunter.exp4j.ExpressionBuilder(conversor).build();
                operations = BigDecimal.valueOf(e.evaluate());
                result = operations.toString();
                if (result.indexOf("000000000") >= 0) {operations = operations.setScale(1, RoundingMode.HALF_UP); result = operations.toString();}
                if (result.endsWith(".0")) {result = result.substring(0, result.length() - 2);}
                lastOperation = conversor + " = " + result;
                lastOperationText.setText(lastOperation);
                numShown = result;
                showResult = false;
            } } } catch(NumberFormatException e) {
                System.out.println("numInvalido");
                bNumCE.doClick();
                numShown = "";
                conversor = "";
                result = "";
                lastOperation = "";
            }
        
    }
}
