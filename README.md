# android-two-way-data-binding

# preview
![device-2021-03-04-192501](https://user-images.githubusercontent.com/29101249/109992004-d9bee280-7d30-11eb-8b56-fcf2d6d356c0.png) 
![device-2021-03-04-192536](https://user-images.githubusercontent.com/29101249/109992045-e3484a80-7d30-11eb-8c65-4f2f454ae332.png)
![device-2021-03-04-192554](https://user-images.githubusercontent.com/29101249/109992070-e9d6c200-7d30-11eb-8a59-3b51b214c5d8.png)

  
# dependencies
## lifecycle components 
 
 def lifecycle_version = "2.3.0"
 
 kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
 
 implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
 
 implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"

## room database
 
 def roomVersion = '2.1.0-rc01'
 
 implementation "androidx.room:room-runtime:$roomVersion"
 
 kapt "androidx.room:room-compiler:$roomVersion"
 
 implementation "androidx.room:room-ktx:$roomVersion"
 
 androidTestImplementation "androidx.room:room-testing:$roomVersion"
 
# License 
   
  Copyright [2021] [Narendra Sharma]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.   
