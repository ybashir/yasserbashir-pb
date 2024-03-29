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

package com.puzzlebazar.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;

import com.puzzlebazar.server.handler.EditUserActionHandler;
import com.puzzlebazar.server.handler.LogoutActionHandler;
import com.puzzlebazar.server.handler.GetCurrentUserActionHandler;
import com.puzzlebazar.server.puzzle.handler.CreateNewPuzzleActionHandler;
import com.puzzlebazar.server.puzzle.handler.GetPuzzleActionHandler;
import com.puzzlebazar.shared.action.CreateNewPuzzleAction;
import com.puzzlebazar.shared.action.EditUserAction;
import com.puzzlebazar.shared.action.GetPuzzleAction;
import com.puzzlebazar.shared.action.LogoutAction;
import com.puzzlebazar.shared.action.GetCurrentUserAction;

/**
 * Module which binds the handlers and configurations.
 * 
 * @author Philippe Beaudoin
 */
public class ServerModule extends HandlerModule {

  @Override
  protected void configureHandlers() {
    bindHandler(LogoutAction.class, LogoutActionHandler.class);
    bindHandler(GetCurrentUserAction.class, GetCurrentUserActionHandler.class);
    bindHandler(EditUserAction.class, EditUserActionHandler.class);
    bindHandler(GetPuzzleAction.class, GetPuzzleActionHandler.class);
    bindHandler(CreateNewPuzzleAction.class, CreateNewPuzzleActionHandler.class);
  }
}
