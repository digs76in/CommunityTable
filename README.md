![CommunityTable is an open source project organized by the Community Tables initiative. It is a technical expression of a much more essential human drive to support _neighbors helping neighbors_._Far Vision: The most vulnerable among us often suffer alone, with limited resources and often without hope. Community Tables builds highly localizable software to strengthen and renew the social contract among neighbors, so that no one struggles in isolation again.](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/community_tables_landing.png "Title and Far Vision")

## Stakeholders
We have identified 3 stakeholders which drive our initiatives. We are building Community Tables products to be easily customized by any local community organizer -- captured by the term _localized_. Our initial efforts are grounded by Michelle, the Founder of Community Table TN. Michelle is our first customer and viewed as our primary stakeholder during this initial product increment. The other two stakeholders are composites of known neighbors in need and community members, respectively. Persona template adapted from [orangebus](http://orangebus.co.uk/insights/the-power-of-proto-personas).

Here are more in-depth profiles of our [Stakeholder Personas](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/stakeholders.md).

## Product Iteration (OCT-DEC 2016)
* __Name:__ Community Cloud Tables
* __Product Iteration Near Vision:__ Community Cloud Tables is a software platform to facilitate, support, and encourage neighbors helping neighbors. Through CCT's highly localizable site templates and features, community organizers can easily customize their site to raise awareness, harness membership, and communicate tailored services to those in need.
* __Key Architecture:__ 
  * Infrastructure: Amazon AWS Cloud Services
  * Java:  Spring MVC / Tomcat
  * Persistence: Mongo DB
  * JavaScript:  Bootstrap / jQuery / ReactJS

Community Cloud Tables is a Java 8 Spring MVC web application which leverages HTML5, CSS3 and third party libraries. The primary data store is a MongoDB database. See the architecture diagram for more details:

![Architecture Diagram](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/community%20tables%20architecture.png)

We have implemented the following CI / CD process:

![CI / CD Process](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/ci_cd.png)

## Product Backlog
Community Tables current product backlog is available to our Scrum Team members and management at [Trello](https://trello.com/b/i9TmhPfB/final-project-community-table)

Reference our [Team Formation Sprint](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md) for our Definition of Ready, Definition of Done, User Story Sizing approach, and starting Product Backlog snapshot. 

### Rationale for Backlog Order
The backlog is ordered by value generated to our stakeholders, namely Community Table TN (the first customer for our open source products). We (as well as our key stakeholder) are starting from scratch (levering other open source software frameworks where feasible). PBIs are groomed to represent excellent users stories within our team's [Definition of Ready](https://github.com/michaeljohns2/CommunityTable/blob/master/sprint0.md#definition-of-ready) and have been estimated by the development team.

## Sprint 3 (11/28 - 12/11)

Our sprint progress is documented at the following link:
[Sprint 3 (11/28-12/11)](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/sprint3.md)

### Release 3 Notes

1. Create a rich-text blog within the Admin Portal (established in Sprint-2). Creator can optionally set a featured image when creating (see #5 below).

 ![Create Blog](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/create_blog.png) 

2. Manage created blogs within the Admin Portal, to include support to delete blogs.  

 ![Manage Blogs](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/manage_blogs.png) 

3. Site has a new public section where blogs are initially listed by configurable excerpt.

 ![List Blogs](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/list_blogs.png) 

4. Any blog can be viewed in full by clicking on either the title or the 'Read full entry' button.

 ![View Blog](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/view_blog.png) 

5. Share blog url to popular social media platforms such as Facebook, using featured image and exposed via [Open Graph](http://ogp.me/) meta tags to render previews. 

 ![Example Blog Social Media](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/blog_social_media.png) 
 
 If no featured image is provided, then a site configured default image is provided.
  
 ![Example Default Img Blog Social Media](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/blog_social_media_default.png) 

## Sprint 2 (11/14-11/25)

Our sprint progress is documented at the following link:
[Sprint 2 (11/14-11/25)](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/sprint2.md)

### Release 2 Notes

1. About Page (backed by highly customizable templates); also supports Google Map API for dynamic location with graceful fallback if missing.
 
 ![Example About Page](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/about_content.png) 

2. Vision Page (also uses templates) to more deeply express the focus and future of the organization.

 ![Example Vision Page-1](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/vision_content_1.png)
 
 _(continued...)_
 
 ![Example Vision Page-2](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/vision_content_2.png)

3. Admin Portal for sensitive site operations, e.g. Member Communication (see below) and Blog Management (estimated sprint3). 

 ![Admin Portal](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/admin_login.png)

4. Allow authorized admins to get a list of emails, ready to copy/paste into email message for ad-hoc communication
 with registered members. This is the first feature to use the new Admin Portal (see above).

 ![Email Lists (Admin)](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/admin_list_emails.png)

## Sprint 1 (10/8-11/11)

Our sprint progress is documented at the following link:
[Sprint 1 (10/8-11/11)](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/sprint1.md)

### Release 1 Notes
1. Compelling site landing page 

 ![Example Landing Page with Email Registration](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/community_table_tn_landing_13NOV2016.png)
 
2. Backed by highly customizable templates ready for your content
  
 ![Example Site Template](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/site_template.png)

3. Customized Welcome Email automatically sent upon registration 

 ![Example Welcome Email](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/welcome_email.png)

4. Unsubscribe link embedded in all site emails

 ![Example Email Unsubscribe Page](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/unsubscribe_success.png)

## Scrum Team
- Scrum Master / Developer (Front End): Melvin Tercan
- Product Owner / Developer (Back End/Front End): Michael Johns
- Developer (Back end) / Meeting Facilitator: Kelly J. Doyle
- Developer (Back end/Front End) / DevOps: Dairai Nyabando
- Developer (Back end): Paul Laskorski
- Developer (Front End/Back End) / DevOps: Vinod Halaharvi
- Developer (Front End) / UX Designer: Shawn Roe

## More Info

Additional developer info can be found in our [Project Setup Notes](https://github.com/michaeljohns2/CommunityTable/blob/master/Project%20Setup%20Notes.md) -- this is a work in progress and most certainly incomplete.

We can also be found in Canvas [Project Group 6](https://canvas.harvard.edu/courses/18031/groups) and on our [Slack](https://agilefall2016.slack.com/messages/community_tables) channel. Our Kanban board can be found at [Trello](https://trello.com/b/i9TmhPfB/final-project-community-table).

##### This is a final project for [Agile Software Development CSCI-E71](http://agilesoftwarecourse.org/) as part of degree requirements for  [Harvard Extension School](http://www.extension.harvard.edu/).

###### Built with love in Austin, Boston, Washington DC, San Francisco, Rhode Island, and Toronto.



