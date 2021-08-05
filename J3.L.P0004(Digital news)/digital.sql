use master
create database digital
use digital
go

create table digital(
	id int primary key,
	title nvarchar(max) ,
	description text ,
	image nvarchar(max) ,
	author nvarchar(max) ,
	dateCreate datetime ,
	shortDes text)


Select top 1 * from digital order by dateCreate


insert into digital values(1,
'The antidote for an acute case of martech bloat','Marketing budgets are bouncing back to pre-Covid
levels after what has been a tough year. But how marketers decide to invest that money has changed, with more resources being redirected 
to digital-first strategies. For example, the retailer Next recently announced it will now prioritise online marketing, stopping all 
other forms of marketing and promotion of its physical stores. As they change tack, marketers are expected to expand their investment 
in martech tools to support their digital efforts.For mid-market businesses with smaller budgets and fewer resources, finding affordable
solutions can be a struggle. And with martech stacks famously underutilised and data syncing a pain, the challenge will be to find tools 
that work for and not against them.So how can marketers avoid their investment resulting in a bad case of martech bloat?',
'i1.jpg',
' Jack Wearne',
cast('2021-05-27' as datetime),
'Marketing budgets are bouncing back to pre-Covid levels after what has been a tough year. But how marketers decide to invest that money has changed, with more resources being redirected to digital-first strategies.')

insert into digital values(2,
'Brightcove helps take Melbourne Symphony Orchestra to a global audience',
'The Melbourne Symphony Orchestra (MSO) has chosen Brightcove to help power its new digital platform, MSO.LIVE. and cast its 2021 season in Australia and around the world.

MSO.LIVE offers 24-hour entertainment on-demand, live and pre-recorded, delivering accessible and premium content as an alternative to traditional, in-person orchestral experiences. The MSO.LIVE experience is accessible, offering MSO concerts, family programming, and special events and performances from around the world.

A key driver for implementing Brightcove’s online video platform is to make performance experiences easily accessible and affordable to a wider audience, including those who are unable to attend in-person concerts.

Sophie Galaise, MD of the Melbourne Symphony Orchestra, said: “Brightcove’s technology delivers a polished interface with exceptional quality of video and audio across multiple devices, to ensure we can deliver easily accessible, world-class digital experiences to all audiences.”

The MSO’s main focus is to optimise its content delivery experience to retain existing orchestral music fans and attract new audiences from around the world to the MSO.LIVE platform. New performances are released monthly, and MSO.LIVE members are able to view content across devices and connected TVs.',
'i1.jpg',
'Duncan MacRae',
cast('2021-05-27' as datetime),
'The Melbourne Symphony Orchestra (MSO) has chosen Brightcove to help power its new digital platform, MSO.LIVE. and cast its 2021 season in Australia and around the world.')

insert into digital values(3,
'The importance of emotional wellbeing in marketing teams – and how to achieve it',
'Performance and productivity has long been the goal of businesses everywhere – always aspiring to do more, better, faster, at less cost. But how do we truly achieve this? Especially in a world where the pace of innovation continues to accelerate?

Often, we think about the key to performance as removing friction, but what if there is an important opportunity in friction? At our recent Attune Summit we had the privilege of hearing from the inspiring Dominic Price, of Atlassian.

Dominic delivered an energetic and insightful session about the importance of getting good at change and investing in ‘fireproofing’ your organisation – not only focusing on getting it right now, but also about putting in the groundwork to ensure businesses continue to get it right in the future.

One of the things that Dominic spoke about was the tendency of many leaders to hire people similar to them. People they can easily relate to and with whom they can get stuff done quickly, with the least amount of conflict.

But good things don’t come easy – and the real wins, the ones that make a long-term impact on a business’s success, are borne out of friction. Out of challenging the status quo and questioning ways of working.',
'i1.jpg',
'Nicole Alvino',
cast('2021-05-26' as datetime),'
Performance and productivity has long been the goal of businesses everywhere – always aspiring to do more, better, faster, at less cost. But how do we truly achieve this? ')

insert into digital values(4,
'How MACH can transform the digital customer experience: A guide',
'There is no doubt that the global Covid-19 pandemic has accelerated digital adoption. For many companies, this move was one they were, understandably, unprepared for. And even for some of those businesses who were already operating online, their technology was either not sufficient enough to adapt at speed, or too general to meet the rapidly changing needs of their customers.

Even post-pandemic, consumer needs are continually evolving, with people shopping on mobile devices, on social networks, and in online marketplaces, even through IoT (Internet of Things) devices. Now more than ever, brands need to offer a true omnichannel experience to reach their audience across all of these platforms, connecting all consumer touchpoints seamlessly.

The demand for a more agile and personalised approach has seen marketers turn towards MACH architecture which allows for speed, scalability and flexibility. By bringing together a set of connected digital services that can run independently from each other.

Not only does this allow companies to make business decisions quicker, it allows for greater innovation to offer a more customer-centric experience. In a competitive marketplace, being innovative and delighting customers with a unique and compelling digital experience can make or break an eCommerce business.',
'i1.jpg',
' Andy Gomes ',
cast('2021-05-26' as datetime),
'There is no doubt that the global Covid-19 pandemic has accelerated digital adoption. For many companies, this move was one they were, understandably, unprepared for. And even for some of those businesses who were already operating online, their technology was either not sufficient enough to...')

insert into digital values(5,
'Spamming vs. cadence – why email marketers should know the difference',
'With more than 300 billion marketing emails delivered every day, savvy brands across the globe are upping the ante in order to achieve the desired cut-through they require from their digital comms.

And while it’s becoming increasingly difficult for marketing departments to land that conversion-led piece of content – against an overwhelming backdrop of online ‘noise’ – the statistics evidence just how important a piece in the jigsaw that email marketing is.

There’s no doubt that this form of communication takes pride of place in a modern-day marketer’s toolkit. After all, a carefully crafted and highly engaging email can enable savvy professionals to strike up an initial, and often all-important, conversation with a customer or prospect.

However, when a recipient requires an average of six touchpoints before a purchase is made, content that’s sent out blindly – and without relevance – can be a complete waste of time for both the marketer and the consumer who wasn’t interested in receiving the message in the first place.

As customers’ needs evolve in a digital-first world, their demands have shone a light on how marketers have to be more sophisticated with their campaigns – and that means getting rid of the bland ‘batch and blast’ emails being sent to a large audience that doesn’t feel listened to or understood by the brand.',
'i1.jpg',
'Adam Oldfield',
cast('2021-05-25' as datetime),
'With more than 300 billion marketing emails delivered every day, savvy brands across the globe are upping the ante in order to achieve the desired cut-through they require from their digital comms.')

insert into digital values(6,
'Falcon.io: On authenticity in social – linking a post-cookie, post-Covid world',
'“When it comes to marketing and social media, data is really telling us the truth – and we always shy away from reading the data and using it because it might make us look bad,” explains Wiebke Leffers, senior strategist at social media platform provider Falcon.io.

“This ‘creative’ feeling of if something worked on social media or not is just outdated,” Leffers adds. “We really need to understand if we are achieving what we [want] on social media.”

It’s the age-old argument. Not all campaigns should be entirely data-driven, one person says at the meeting. We need to retain some human intuition and creativity, says another. But the truth is there’s no reason to say why you can’t have both.

Falcon.io is part of the Cision stable, having been acquired at the beginning of 2019. Earlier this year, to great fanfare, Cision announced its intention to acquire Brandwatch, the provider of digital consumer intelligence and – increasingly – social listening.

The combination of Brandwatch and Falcon.io will be a fascinating one. Indeed, while it’s still early days, Leffers is speaking with Mercedes Lois Bull, product marketing manager at Brandwatch, at the upcoming DMWF Global event on June 2-3. Building out a data-driven framework will be a key learning point during their session. “We can’t close our eyes anymore and not use the hard facts data is giving us,” Leffers adds.',
'i1.jpg',
'James Bourne',
cast('2021-05-24' as datetime),'
"When it comes to marketing and social media, data is really telling us the truth - and we always shy away from reading the data and using it because it might make us look bad," explains Wiebke Leffers...')

insert into digital values(7,
'Why automation is your greatest ally – if you use it right',
'As an agency owner or marketer, you’re in constant pursuit of two things: demonstrating return on investment and landing new clients. The past year has only intensified the necessity of these pursuits — especially the latter — as you likely tried to help clients through the challenges of the pandemic while shortening and digitising your sales pipeline.

When used properly, marketing automation can make your sales process more efficient and scalable. By automating tasks that allow you to quickly aggregate, interpret, and apply relevant data, you can free up time to focus on current clients’ campaigns. That’s why 42% of marketers (pdf) use automation to acquire new customers.

Paid options like Google Ads pit you against others in high-stakes keyword bids, draining your budget along the way. Automation, on the other hand, allows you to take control of your pipeline while decreasing overhead costs. But it’s only as effective as you make it. To get the most out of your marketing automation initiatives, you’ll need to think about how to truly improve your sales process.',
'i1.jpg',
'Drew McLellan',
cast('2021-05-26' as datetime),
'As an agency owner or marketer, you’re in constant pursuit of two things: demonstrating return on investment and landing new clients. The past year has only intensified the necessity of these pursuits')