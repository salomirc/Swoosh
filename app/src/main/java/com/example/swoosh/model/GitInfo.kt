import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2019 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class GitInfo (

	@SerializedName("url") val url : String,
	@SerializedName("forks_url") val forks_url : String,
	@SerializedName("commits_url") val commits_url : String,
	@SerializedName("id") val id : String,
	@SerializedName("node_id") val node_id : String,
	@SerializedName("git_pull_url") val git_pull_url : String,
	@SerializedName("git_push_url") val git_push_url : String,
	@SerializedName("html_url") val html_url : String,
	@SerializedName("public") val public : Boolean,
	@SerializedName("created_at") val created_at : String,
	@SerializedName("updated_at") val updated_at : String,
	@SerializedName("description") val description : String,
	@SerializedName("comments") val comments : Int,
	@SerializedName("user") val user : String?,
	@SerializedName("comments_url") val comments_url : String,
	@SerializedName("owner") val owner : Owner,
	@SerializedName("forks") val forks : List<String>,
	@SerializedName("history") val history : List<History>,
	@SerializedName("truncated") val truncated : Boolean
)
