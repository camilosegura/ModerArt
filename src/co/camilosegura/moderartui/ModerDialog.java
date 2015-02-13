/**
 * ModerArt
 * Copyright (C) 2015  Camilo Segura
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License,
 * with the "Linking Exception", which can be found at the license.txt
 * file in this program.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 */
package co.camilosegura.moderartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
/**
 * Manage a Dialog than can open a web browser 
 * and show the MoMA web page 
 * @author camilo segura
 *
 */
public class ModerDialog extends DialogFragment {
	/**
	 * Create an instance from this class 
	 * @return
	 */
	public static ModerDialog newInstance(){
		return new ModerDialog();
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstance){
		AlertDialog.Builder bDialog = new AlertDialog.Builder(getActivity());
		bDialog.setMessage(R.string.dialog_message);
		bDialog.setCancelable(false);
		bDialog.setNegativeButton(R.string.dialog_negative, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		
		bDialog.setPositiveButton(R.string.dialog_positive, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://www.moma.org/");
				Intent webPage = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(webPage);
			}
		});
		
		Dialog dialog = bDialog.create();
		
		return dialog;
	}
}
