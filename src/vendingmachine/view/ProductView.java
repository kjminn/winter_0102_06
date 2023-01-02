package vendingmachine.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vendingmachine.vo.ProductVO;

public class ProductView {
	ArrayList<ProductVO> productList;
	ArrayList<JLabel> lblList = new ArrayList<JLabel>();
	JTextField insertTf = new JTextField(10);
	JLabel lblResult = new JLabel("제품이 나오는 곳");
	JFrame frame;
	ProductVO vo;
	
	public JPanel displayProducts(JFrame frame) {
		this.frame = frame;
		JPanel panC = new JPanel(new GridLayout(3, 3));
		for (ProductVO vo : productList) {
			ImageIcon icon = new ImageIcon("images/"+vo.getImageName()+".jpg");
			JLabel lbl = new JLabel(icon);
			lbl.addMouseListener(lblL);
			lblList.add(lbl);
			panC.add(lbl);
		}
		return panC;
	}
	
	public JPanel inputPurchase() {
		JPanel panS = new JPanel();
		JLabel lblMoney = new JLabel("금액: ");
		JButton btnInsert = new JButton("투입");
		btnInsert.addActionListener(btnL);
		panS.add(lblMoney); panS.add(insertTf); panS.add(btnInsert);
		panS.add(lblResult);
		return panS;
	}
 
	public void setProductList(ArrayList<ProductVO> productList) {
		this.productList = productList;
	}
	
	MouseAdapter lblL = new MouseAdapter(){
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			for (int i = 0; i < lblList.size(); i++) {
				if(e.getSource() == lblList.get(i)) {
					vo = productList.get(i);
				}
			}
			JOptionPane.showMessageDialog(frame, "제품명: "+vo.getName()+", 제품가격: "+vo.getPrice()+"원");			
		}
	};
	
	ActionListener btnL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
//			투입버튼이 클릭되었을 때
//			JTextField에 입력된 금액과 현재 금액을 비교하여 양수이상이면 제품과 거스름돈이 나오게
//			금액이 부족하면 부족하다고 출력하여 다시 금액을 입력할 수 있게함
			int money = Integer.parseInt(insertTf.getText());
			if(money >= vo.getPrice()) {
				lblResult.setText(vo.getName()+"제품 나옴, 거스름돈 "+(money-vo.getPrice())+"원");
			}else {
				lblResult.setText("금액이 부족합니다.");
			}
		}
	};
}







