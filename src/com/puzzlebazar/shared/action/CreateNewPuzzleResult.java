package com.puzzlebazar.shared.action;

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

import com.philbeaudoin.gwtp.dispatch.shared.Result;
import com.puzzlebazar.shared.puzzle.heyawake.model.HeyawakePuzzle;

public class CreateNewPuzzleResult implements Result {

  private static final long serialVersionUID = -4123124901295191789L;
  
  // TODO This should really be a generic puzzle type
  private HeyawakePuzzle puzzle;

  @SuppressWarnings("unused")
  private CreateNewPuzzleResult() {
    // For serialization only
  }

  public CreateNewPuzzleResult(HeyawakePuzzle puzzle) {
    this.puzzle = puzzle;
  }
  
  public HeyawakePuzzle getPuzzle() {
    return puzzle;
  }
}
