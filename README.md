# Discogs BigQuery importer

## Raison d'être

Scio Dataflow job to load the [discogs xml dumps](https://discogs-data-dumps.s3.us-west-2.amazonaws.com/index.html) into BigQuery tables.

## Running

Current available jobs: 

- [x] Labels
- [x] Artists
- [x] Masters
- [x] Releases

To run the jobs, download the compressed XML dumps and upload them to your own gcp bucket.
Follow the [Scio instructions](https://spotify.github.io/scio/Getting-Started.html) to set up your GCP project.

All the times were measured using the default run arguments for Dataflow.

### Releases (~ 1 hour)

```
sbt "runMain discogs.ReleasesJob
  --project=your-gpc-project-id
  --runner=DataflowRunner
  --region=us-central1
  --input=gs://your-bucket/releases.xml.gz
  --output=your-project.bq-dataset.releases-bq-table"
```

### Artists (~ 11 minutes)

```
sbt "runMain discogs.ArtistsJob
  --project=your-gpc-project-id
  --runner=DataflowRunner
  --region=us-central1
  --input=gs://your-bucket/artists.xml.gz
  --output=your-project.bq-dataset.artists-bq-table"
```

### Masters (~ 6 minutes)

```
sbt "runMain discogs.MastersJob
  --project=your-gpc-project-id
  --runner=DataflowRunner
  --region=us-central1
  --input=gs://your-bucket/masters.xml.gz
  --output=your-project.bq-dataset.masters-bq-table"
```

### Labels (~ 6 minutes)

Because of an Apache Beam [XmlIO](https://beam.apache.org/releases/javadoc/2.3.0/org/apache/beam/sdk/io/xml/XmlIO.html) limitation regarding
nested tags with the same outer label (`<label>`), the original labels file cannot be processed as is. There's a small
script to convert the nested `<labels>` tags into `<sublabels>` in `src/main/java/utils/LabelRenamer.java`. Download the original final, decompress it
and run the converter. Then compress the output file and upload it to your GCP bucket. Then use that file as the input for the job.

```
sbt "runMain discogs.MastersJob
  --project=your-gpc-project-id
  --runner=DataflowRunner
  --region=us-central1
  --input=gs://your-bucket/labels-renamed.xml.gz
  --output=your-project.bq-dataset.labels-bq-table"
```
