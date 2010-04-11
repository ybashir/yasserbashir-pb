package com.puzzlebazar.shared.puzzle.model;

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


import java.io.Serializable;

import com.puzzlebazar.shared.model.HasKey;

/**
 * All the information regarding one specific type of puzzle.
 * 
 * @author Philippe Beaudoin
 */
public interface PuzzleType extends Serializable, HasKey {

  /**
   * Access a simple human-readable string describing the puzzle type.
   * 
   * @return A string indicating the type of the puzzle.
   */
  String getSimpleName();
  
}
