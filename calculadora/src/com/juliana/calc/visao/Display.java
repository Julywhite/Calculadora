package com.juliana.calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.juliana.calc.modelo.Memoria;
import com.juliana.calc.modelo.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador{

	private final JLabel label;
	
	public Display() {
		Memoria.getInstancia().adicionarObservador(this);

		setBackground(new Color(46, 49, 50));
		label = new JLabel(Memoria.getInstancia().getTextoAtual());
		label.setForeground(Color.WHITE); // cor da fonte
		label.setFont(new Font("courier", Font.PLAIN, 30)); // tipo de fornte e tamanho
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 40)); // alinha texto do display à direita / recuo / distancia do limite em cima
		
		add(label);
		
	}

	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
	}
}
