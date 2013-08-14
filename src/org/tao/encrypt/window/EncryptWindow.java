package org.tao.encrypt.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.tao.encrypt.util.EncodeUtil;

public class EncryptWindow {

	protected Shell shell;
	private GridLayout layout;
	private Text text;
	private Label label;
	private Button btnButton;
	private Label labelBase64;
	private Label labelMD5;
	private Label labelSHA1;
	private Text labelBase64Value;
	private Text labelMD5Value;
	private Text labelSHA1Value;

	/**
	 * Open the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(Display.getCurrent(), SWT.DIALOG_TRIM);
		shell.setSize(482, 213);
		shell.setText("加密框");
		Image image = new Image(Display.getCurrent(), this.getClass().getResourceAsStream("/org/tao/encrypt/resource/ico.ico"));
		shell.setImage(image);
		layout = new GridLayout(3, false);
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 20;
		layout.marginWidth = 20;
		layout.marginHeight = 20;
		shell.setLayout(layout);

		label = new Label(shell, SWT.NONE);
		label.setText("请输入值：");

		text = new Text(shell, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		btnButton = new Button(shell, SWT.NONE);
		btnButton.setText("加密");
		btnButton.setLayoutData(new GridData(50, 25));

		labelBase64 = new Label(shell, SWT.NONE);
		labelBase64.setText("Base64：");
		labelBase64Value = new Text(shell, SWT.NONE | SWT.READ_ONLY);
		labelBase64Value.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

		labelMD5 = new Label(shell, SWT.NONE);
		labelMD5.setText("MD5：");
		labelMD5Value = new Text(shell, SWT.NONE | SWT.READ_ONLY);
		labelMD5Value.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

		labelSHA1 = new Label(shell, SWT.NONE);
		labelSHA1.setText("SHA1：");
		labelSHA1Value = new Text(shell, SWT.NONE | SWT.READ_ONLY);
		labelSHA1Value.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

		btnButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent selectionevent) {
				String value = text.getText();
				if (value == null || value.trim().equals("")) {
					MessageBox messageBox = new MessageBox(shell,
							SWT.ICON_WARNING);
					messageBox.setText("警告");
					messageBox.setMessage("值不能为空");
					messageBox.open();
					return;
				} else {
					labelBase64Value.setText(EncodeUtil.encodeBase64(value));
					labelMD5Value.setText(EncodeUtil.encodeMD5(value));
					labelSHA1Value.setText(EncodeUtil.encodeSHA1(value));
				}
			}
		});
	}
}
