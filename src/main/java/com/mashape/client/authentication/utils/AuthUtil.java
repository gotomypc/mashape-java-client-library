/*
 * 
 * Mashape Java Client library.
 * Copyright (C) 2011 Mashape, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 * The author of this software is Mashape, Inc.
 * For any question or feedback please contact us at: support@mashape.com
 * 
 */

package com.mashape.client.authentication.utils;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import com.mashape.client.http.utils.CryptUtils;

public class AuthUtil {

	public static Header generateAuthenticationHeader(String publicKey, String privateKey) {
		if (!(publicKey == null || privateKey == null)) {
			String hash = CryptUtils.getHMAC_SHA1(publicKey, privateKey);
			String headerValue = publicKey + ":" + hash;
			return new BasicHeader("X-Mashape-Authorization", Base64.encode(new String(headerValue.getBytes())).replace("\r\n", ""));
		}
		return null;
	}
}
