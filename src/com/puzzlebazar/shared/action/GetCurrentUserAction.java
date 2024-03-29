/**
 * Copyright 2010 Philippe Beaudoin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.puzzlebazar.shared.action;

import com.gwtplatform.dispatch.shared.UnsecuredActionImpl;

/**
 * This action returns the currently logged-in user. It is unsecured, as it is called
 * as soon as the user connects to the page, and we don't want XSRF warnings if
 * the user doesn't accept cookies.
 * 
 * @author Philippe Beaudoin
 */
public class GetCurrentUserAction extends UnsecuredActionImpl< GetUserResult > {
  
}
